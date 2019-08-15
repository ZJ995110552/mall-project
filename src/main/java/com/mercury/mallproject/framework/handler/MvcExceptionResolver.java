package com.mercury.mallproject.framework.handler;

import com.alibaba.fastjson.JSON;
import com.mercury.mallproject.common.exception.Exceptions;
import com.mercury.mallproject.common.exception.ServiceException;
import com.mercury.mallproject.common.response.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * mvc异常处理器
 */
@Component
@Slf4j
public class MvcExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            String errorMsg = "";
            boolean isAjax = "1".equals(request.getParameter("isAjax"));

            //ex 为业务层抛出的自定义异常
            if (ex instanceof ServiceException) {
                ServiceException serviceException = (ServiceException) ex;
                errorMsg = serviceException.getMessage();
                log.error(serviceException.getMessage());
            } else {
                //ex为非自定义异常
                errorMsg = Exceptions.getWrapper(ex).getMessage();
                log.error(errorMsg);
            }

            if (isAjax) {
                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().write(JSON.toJSONString(R.error(Exceptions.getWrapper(ex).getMessage())));
                return new ModelAndView();
            } else {
                //否则，  输出错误信息到自定义的500页面
                ModelAndView mv = new ModelAndView("/error/500.html");
                mv.addObject("errorMsg", Exceptions.getWrapper(ex).getMessage());
                return mv;
            }
        } catch (IOException e) {
            log.error(ExceptionUtils.getStackTrace(e));
        }
        return new ModelAndView();

    }

}