package com.bsoft.office.sysconfig.exception;

import com.bsoft.exception.ServiceException;
import com.bsoft.office.common.exception.NoLogonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice  //确保能被扫描到并装载进 Spring 容器中
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public ExceptionResult ServiceExceptionHandler(ServiceException e){
        log.error("自定义异常：{}",e.getMessage());
        return new ExceptionResult(500,e.getMessage());
    }

    @ExceptionHandler(NoLogonException.class)
    public ExceptionResult exceptionHandler(NoLogonException e, HttpServletRequest request){
        log.error("发生未知异常：{}", e.getMessage());
        return new ExceptionResult(999,e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ExceptionResult exceptionHandler(Exception e, HttpServletRequest request){
        log.error("发生未知异常：{}", e.getMessage());
        return new ExceptionResult(500,"请求异常，请稍后重试！");
    }
}
