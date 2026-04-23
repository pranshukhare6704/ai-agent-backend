package com.pranshu.aiagent.tool;

import com.pranshu.aiagent.dto.ChatResponse;
import com.pranshu.aiagent.service.AiProviderService;
import org.springframework.stereotype.Component;

@Component
public class AiChatTool implements ToolExecutor {

    private final AiProviderService aiProviderService;

    public AiChatTool(AiProviderService aiProviderService) {
        this.aiProviderService = aiProviderService;
    }

    @Override
    public ChatResponse execute(String message) {
        return new ChatResponse(aiProviderService.askAi(message));
    }
}