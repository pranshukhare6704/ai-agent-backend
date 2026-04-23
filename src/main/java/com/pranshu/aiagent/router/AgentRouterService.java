package com.pranshu.aiagent.router;

import com.pranshu.aiagent.dto.ChatResponse;
import com.pranshu.aiagent.tool.AiChatTool;
import com.pranshu.aiagent.tool.TimeTool;
import org.springframework.stereotype.Service;

@Service
public class AgentRouterService {

    private final AiChatTool aiChatTool;
    private final TimeTool timeTool;

    public AgentRouterService(
            AiChatTool aiChatTool,
            TimeTool timeTool
    ) {
        this.aiChatTool = aiChatTool;
        this.timeTool = timeTool;
    }

    public ChatResponse route(String message) {

        if (message.toLowerCase().contains("time")) {
            return timeTool.execute(message);
        }

        return aiChatTool.execute(message);
    }
}