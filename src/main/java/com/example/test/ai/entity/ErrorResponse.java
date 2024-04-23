package com.example.test.ai.entity;


import lombok.Getter;
import lombok.Setter;
import org.codehaus.groovy.ast.expr.FieldExpression;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter

public class ErrorResponse {

    
    private String errorCode;
    
    
    private List<FieldError> expressions;
    
    public ErrorResponse(String errorCode) {
        this.errorCode = errorCode;
        if (this.expressions == null) {
            this.expressions = new ArrayList<>();
        }
    }
    public void setFieldError(List<FieldError> fieldErrors){
        List<FieldError> collect = fieldErrors.stream().map(err -> new FieldError(err.getObjectName(), err.getField(), err.getDefaultMessage()))
                .collect(Collectors.toList());
        this.setExpressions(collect);
    }
}
