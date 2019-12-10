package com.provider.cloudprovider.exception;

import com.example.cloudcommons.resp.ResponseMsg;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description: cloud-provider-2项目全局异常处理
 * @author: Carter
 * @create: 2019-12-10
 **/

/**在spring 3.2中，新增了@ControllerAdvice，@RestControllerAdvice 注解*/
@RestControllerAdvice
public class GlobalExceptionsHandler {

    /**
     * 处理自定义异常
     * 拦截ValidationException类型的异常   ValidationException类继承了RuntimeException  相当于拦截RuntimeException
     */
    @ExceptionHandler(ValidationException.class)
    public ResponseMsg handleRRException(ValidationException e){
        return new ResponseMsg(e.getCode(), null, e.getMessage());
    }

}
