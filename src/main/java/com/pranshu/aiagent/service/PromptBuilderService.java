package com.pranshu.aiagent.service;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PromptBuilderService {

    public String buildPrompt(List<String> history) {

        String instruction = """
                You are a helpful AI assistant for Indian competitive exam preparation and general queries.
                
                Rules:
                - Answer concisely and directly.
                - Do not give unnecessary explanation.
                - If a term is ambiguous, assume Indian context unless specified otherwise.
                - For exams like UPTGT, assume Uttar Pradesh Teacher Eligibility/Graduate Teacher exam.
                - If real-time data like current time is asked, give best possible direct answer or clearly say not available.
                - Do not hallucinate unknown facts.
                """;

        String conversation = String.join("\n", history);
        return instruction + "\n\nConversation:\n" +conversation + "\nAI:";
    }
}
