package com.ybl.studyflow.exception;

import com.ybl.studyflow.common.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public Result<Void> handle(BusinessException e){
        return Result.error(e.getMessage());
    }
}
