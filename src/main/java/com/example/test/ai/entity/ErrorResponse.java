package com.example.test.ai.entity;


import lombok.Getter;
import lombok.Setter;
import org.codehaus.groovy.ast.expr.FieldExpression;
import org.springframework.validation.FieldError;

import java.util.*;
import java.util.stream.Collectors;


@Getter
@Setter
public class ErrorResponse {
    
    
    private String errorCode;
    
    
    private List<Map<String,String>> expressions;
    
    public ErrorResponse(String errorCode) {
        this.errorCode = errorCode;
    }
    
    public void setFieldError(List<FieldError> fieldErrors) {
        if (this.expressions == null) {
            this.expressions = new ArrayList<>();
        }
        fieldErrors.forEach(err -> {
                    Map<String, String> map = new HashMap<>();
                    map.put(err.getObjectName(), err.getDefaultMessage());
                    this.expressions.add(map);
                });
        
        
    }
}
