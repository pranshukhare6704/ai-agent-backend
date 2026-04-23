package com.pranshu.aiagent.tool;
import com.pranshu.aiagent.dto.ChatResponse;
import org.springframework.stereotype.Component;

@Component
public class GeneralChatTool implements ToolExecutor {

    @Override
    public ChatResponse execute(String message){
        return new ChatResponse("AI Agent says: You said ->" + message);
    }
}
