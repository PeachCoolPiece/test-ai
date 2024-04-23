package com.example.test.ai.entity;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.ai.openai.OpenAiChatClient;

@Getter
@Setter
public class Chat {
    
    @NotBlank
    private String prompt;
    
    
    
    private String responseMessage;
    
    
    public void response(OpenAiChatClient chatClient) {
        this.responseMessage = chatClient.call(this.getPrompt());
    }
}
