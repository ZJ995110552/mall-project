package com.mercury.mallproject.common.exception;


public class Exceptions {

    public static ServiceException getWrapper(Exception exception) {
        ServiceException serviceException = null;
        if (exception instanceof IllegalArgumentException) {
            serviceException = new ServiceException(exception.getMessage(), exception);
            serviceException.setExcType(ServiceException.ExceptionType.EXTERNAL);
            serviceException.setLevel(ServiceException.ExceptionLevel.WRAN);
            serviceException.unKonwn(false);
        } else if (exception instanceof ServiceException) {
            serviceException = (ServiceException) exception;
        } else {
            serviceException = new ServiceException("程序出现问题,请联系管理员", exception);
            serviceException.unKonwn(true);
        }
        return serviceException;
    }

}
