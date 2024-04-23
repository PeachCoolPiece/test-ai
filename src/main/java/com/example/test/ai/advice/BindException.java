package com.example.test.ai.advice;


import com.example.test.ai.entity.ErrorResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice(basePackages = "com.example.test.controller")
public class BindException {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ErrorResponse ex(BindingResult bindingResult) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        ErrorResponse errorResponse = new ErrorResponse("400");
        errorResponse.setFieldError(fieldErrors);
        return errorResponse;
    }
    
 
}
