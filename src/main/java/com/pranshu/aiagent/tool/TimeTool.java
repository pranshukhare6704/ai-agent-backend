package com.pranshu.aiagent.tool;
import com.pranshu.aiagent.dto.ChatResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TimeTool implements ToolExecutor {

    @Override
    public ChatResponse execute(String message){
        return new ChatResponse(
                "Current system time is :" + LocalDateTime.now()
        );
    }
}
