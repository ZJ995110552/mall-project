package com.mercury.mallproject.common.exception;


import com.mercury.mallproject.common.exception.file.FileNameLengthLimitExceededException;

public class Exceptions {

    public static ServiceException getWrapper(Exception exception) {
        ServiceException serviceException = null;
//        if(exception instanceof FileNameLengthLimitExceededException){
//            serviceException = new ServiceException(exception.getMessage(), exception);
//            serviceException.setExcType(ServiceException.ExceptionType.EXTERNAL);
//            serviceException.setLevel(ServiceException.ExceptionLevel.INFO);
//            serviceException.unKonwn(false);
//        }else
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

    public static void main(String[] args) {
        FileNameLengthLimitExceededException excel_ = new FileNameLengthLimitExceededException("Excel ", 100, 10);
        ServiceException wrapper = Exceptions.getWrapper(excel_);
//        returnResult.setMessage(wrapper.getMessage()); // Controller层返回统一封装信息
        System.out.println(wrapper.getMessage()+" "+wrapper.getId());
        System.out.println(wrapper.getStackTrace().toString());
    }

}
