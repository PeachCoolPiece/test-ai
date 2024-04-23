package com.example.test.controller;

import com.example.test.ai.entity.Chat;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.Map;

@RestController
@RequestMapping("/ai")
@RequiredArgsConstructor
public class ChatController {
    
    private final OpenAiChatClient chatClient;
    
    @GetMapping("/generate")
    public Map<String,String> generate(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        Map<String, String> generation = Map.of("generation", chatClient.call(message));
        return generation;
    }
    
    @GetMapping("/generateStream")
    public Flux<ChatResponse> generateStream(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        Prompt prompt = new Prompt(new UserMessage(message));
        return chatClient.stream(prompt);
    }
    
    @PostMapping("/generate")
    public Map<String, Chat> test(@Validated @ModelAttribute("chat") Chat chat) {
        chat.response(chatClient);
        return Map.of("generation", chat);
    }
}
