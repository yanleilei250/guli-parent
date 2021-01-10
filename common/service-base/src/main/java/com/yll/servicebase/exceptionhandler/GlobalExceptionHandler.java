package com.yll.servicebase.exceptionhandler;



import com.yll.commonutils.R;
import io.swagger.annotations.ResponseHeader;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author 颜起名
 * @create date 2020-07-25-17:53
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseHeader
    public R error(Exception e){
        e.getMessage();
        return R.error().message("有异常，请检查");
    }
}
