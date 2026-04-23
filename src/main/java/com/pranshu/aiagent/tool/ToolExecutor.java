package com.pranshu.aiagent.tool;
import com.pranshu.aiagent.dto.ChatResponse;

public interface ToolExecutor {
    ChatResponse execute(String message);
}
