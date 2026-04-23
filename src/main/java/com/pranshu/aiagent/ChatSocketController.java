package com.pranshu.aiagent;

import com.pranshu.aiagent.dto.ChatRequest;
import com.pranshu.aiagent.dto.ChatResponse;
import com.pranshu.aiagent.service.ChatService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatSocketController {

    private final ChatService chatService;

    public ChatSocketController(ChatService chatService) {
        this.chatService = chatService;
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public ChatResponse liveChat(ChatRequest request) {
        return chatService.generateReply(request.getMessage(), request.getSessionId());
    }
}