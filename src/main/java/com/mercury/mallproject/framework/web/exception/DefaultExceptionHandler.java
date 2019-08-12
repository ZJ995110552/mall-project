package com.mercury.mallproject.framework.web.exception;

import com.mercury.mallproject.common.response.R1;
import com.mercury.mallproject.common.utils.sys.PermissionUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 自定义异常处理器
 * 
 * @author ruoyi
 */
@RestControllerAdvice
public class DefaultExceptionHandler
{
    private static final Logger log = LoggerFactory.getLogger(DefaultExceptionHandler.class);
    
    /**
     * 权限校验失败
     */
    @ExceptionHandler(AuthorizationException.class)
    public R1 handleAuthorizationException(AuthorizationException e)
    {
        log.error(e.getMessage(), e);
        return R1.error(PermissionUtils.getMsg(e.getMessage()));
    }

    /**
     * 请求方式不支持
     */
    @ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
    public R1 handleException(HttpRequestMethodNotSupportedException e)
    {
        log.error(e.getMessage(), e);
        return R1.error("不支持' " + e.getMethod() + "'请求");
    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public R1 notFount(RuntimeException e)
    {
        log.error("运行时异常:", e);
        return R1.error("运行时异常:" + e.getMessage());
    }

    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public R1 handleException(Exception e)
    {
        log.error(e.getMessage(), e);
        return R1.error("服务器错误，请联系管理员");
    }


}
