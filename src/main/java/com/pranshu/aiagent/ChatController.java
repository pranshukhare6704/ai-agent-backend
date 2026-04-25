package com.pranshu.aiagent;

import com.pranshu.aiagent.dto.ChatRequest;
import com.pranshu.aiagent.dto.ChatResponse;
import org.springframework.web.bind.annotation.*;
import com.pranshu.aiagent.service.ChatService;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "*") 
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {
        return chatService.generateReply(request.getMessage(), request.getSessionId());
    }
}