package com.example.test.ai.entity;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chat {
    
    @NotBlank
    private String prompt;
    
    
    private String responseMessage;
    
    
}
