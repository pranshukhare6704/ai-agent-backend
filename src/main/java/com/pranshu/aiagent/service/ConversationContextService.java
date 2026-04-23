package com.pranshu.aiagent.service;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ConversationContextService {

    private final Map<String, List<String>> conversationStore = new HashMap<>();

    public List<String> getConversation(String sessionId) {
         return conversationStore.computeIfAbsent(sessionId, k -> new ArrayList<>());
    }

    public void addMessage(String sessionId, String message){
        List<String> messages = getConversation(sessionId);
        messages.add(message);

        if(messages.size()>10){
            messages.remove(0);
        }
    }

}
