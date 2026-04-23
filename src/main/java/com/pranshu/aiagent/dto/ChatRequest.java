package com.pranshu.aiagent.dto;

public class ChatRequest {

    private String message ;
    private String sessionId;

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
    public String getSessionId(){
        return sessionId;
    }

}
