package com.pranshu.aiagent.service;

import org.springframework.stereotype.Service;
import com.pranshu.aiagent.router.AgentRouterService;
import com.pranshu.aiagent.dto.ChatResponse;
import java.util.List;

@Service
public class ChatService {

    private final AiProviderService aiProviderService;
    private final ConversationContextService conversationContextService;
    private final PromptBuilderService promptBuilderService;

    public ChatService (
            AiProviderService aiProviderService,
            ConversationContextService conversationContextService,
            PromptBuilderService promptBuilderService
    ){
        this.aiProviderService = aiProviderService;
        this.conversationContextService = conversationContextService;
        this.promptBuilderService = promptBuilderService;
    }

        public ChatResponse generateReply(String message, String requestSessionId) {

            String sessionId = (requestSessionId == null || requestSessionId.isBlank())
                    ? "default-session"
                    : requestSessionId ;
            conversationContextService.addMessage(sessionId, "User: " + message);
            List<String> history = conversationContextService.getConversation(sessionId);
            String prompt = promptBuilderService.buildPrompt(history);
            String aiReply = aiProviderService.askAi(prompt);
            conversationContextService.addMessage(sessionId, "AI: " + aiReply);
            return new ChatResponse(aiReply);

        }
}
