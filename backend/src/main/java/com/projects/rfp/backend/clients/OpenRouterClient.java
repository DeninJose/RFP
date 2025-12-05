package com.projects.rfp.backend.clients;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class OpenRouterClient {

    @Value("${openrouter.api.key}")
    private String apiKey;

    @Value("${openrouter.base.url}")
    private String baseUrl;

    @Value("${openrouter.model}")
    private String model;

    private final ObjectMapper objectMapper;
    private final RestClient restClient;

    public OpenRouterClient(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.restClient = RestClient.builder()
                .baseUrl("https://openrouter.ai/api/v1")
                .build();
    }

    public String chat(String systemPrompt, String userPrompt) {
        log.debug("Making OpenRouter API call");

        try {
            // Build request body
            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("model", model);
            requestBody.put("messages", List.of(
                    Map.of("role", "system", "content", systemPrompt),
                    Map.of("role", "user", "content", userPrompt)
            ));
            requestBody.put("temperature", 0.7);

            // Make API call
            String response = restClient.post()
                    .uri("/chat/completions")
                    .header("Authorization", "Bearer " + apiKey)
                    .header("Content-Type", "application/json")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(requestBody)
                    .retrieve()
                    .body(String.class);

            log.debug("OpenRouter response: {}", response);

            // Parse response to extract content
            JsonNode responseNode = objectMapper.readTree(response);
            String content = responseNode
                    .path("choices")
                    .get(0)
                    .path("message")
                    .path("content")
                    .asText();

            return cleanResponse(content);

        } catch (Exception e) {
            log.error("Failed to make OpenRouter API call", e);
            throw new RuntimeException("Failed to communicate with AI service: " + e.getMessage(), e);
        }
    }

    private String cleanResponse(String content) {
        // Clean response (remove markdown if present)
        return content.trim()
                .replaceFirst("^```json\\s*", "")
                .replaceFirst("^```\\s*", "")
                .replaceFirst("```\\s*$", "")
                .trim();
    }
}
