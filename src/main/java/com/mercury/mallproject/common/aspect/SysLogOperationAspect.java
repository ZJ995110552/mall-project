package com.mercury.mallproject.common.aspect;


import com.alibaba.fastjson.JSON;
import com.google.common.net.HttpHeaders;
import com.mercury.mallproject.common.annotation.OperationLogger;
import com.mercury.mallproject.common.enums.OperationStatusEnum;
import com.mercury.mallproject.common.utils.HttpContextUtils;
import com.mercury.mallproject.common.utils.IpUtils;
import com.mercury.mallproject.log.domain.SysLogOperation;
import com.mercury.mallproject.log.service.SysLogOperationService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;


@Aspect
@Component
public class SysLogOperationAspect {
    private static final Logger logger = LoggerFactory.getLogger(SysLogOperationAspect.class);

    @Autowired
    private SysLogOperationService sysLogOperationService;

    @Pointcut("@annotation(com.mercury.mallproject.common.annotation.OperationLogger)")
    public void logPointCut() {

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        try {
            //执行方法
            Object result = point.proceed();

            //执行时长(毫秒)
            long time = System.currentTimeMillis() - beginTime;
            //保存日志
            saveLog(point, time, OperationStatusEnum.SUCCESS.getCode());

            return result;
        } catch (Exception e) {
            //执行时长(毫秒)
            long time = System.currentTimeMillis() - beginTime;
            //保存日志
            saveLog(point, time, OperationStatusEnum.FAIL.getCode());

            throw e;
        }
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long time, Integer status) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        SysLogOperation log = new SysLogOperation();
        OperationLogger annotation = method.getAnnotation(OperationLogger.class);
        if (annotation != null) {
            //注解上的描述
            log.setOperation(annotation.modelName());
        }

        //登录用户信息
//        UserDetail user = SecurityUser.getUser();
//        if(user != null){
//            log.setCreatorName(user.getUsername());
//        }

        log.setStatus(status);
        log.setRequestTime((int) time);

        //请求相关信息
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        log.setIp(IpUtils.getIpAddr(request));
        log.setUserAgent(request.getHeader(HttpHeaders.USER_AGENT));
        log.setRequestUri(request.getRequestURI());
        log.setRequestMethod(request.getMethod());

        //请求参数
        Object[] args = joinPoint.getArgs();
        try {
            String params = JSON.toJSONString(args[0]);
            log.setRequestParams(params);
        } catch (Exception e) {

        }

        //保存到DB
        sysLogOperationService.addObject(log);
    }
}
