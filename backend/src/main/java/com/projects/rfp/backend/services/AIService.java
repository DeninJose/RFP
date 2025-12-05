package com.projects.rfp.backend.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projects.rfp.backend.adapters.ProcurementAdapter;
import com.projects.rfp.backend.clients.OpenRouterClient;
import com.projects.rfp.backend.dtos.AIResponse;
import com.projects.rfp.backend.dtos.ProcurementDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AIService {

    private final OpenRouterClient openRouterClient;
    private final ObjectMapper objectMapper;
    private final ProcurementAdapter procurementAdapter;

    public ProcurementDto generateProcurementFromText(String textQuery) {
        log.info("Generating procurement with products from text: {}", textQuery);

        try {
            String systemPrompt = "You are a procurement assistant that extracts structured data from text.";
            String userPrompt = buildPrompt(textQuery);

            // Get response from AI client
            String aiResponseContent = openRouterClient.chat(systemPrompt, userPrompt);

            log.info("AI Response content: {}", aiResponseContent);

            // Parse JSON response
            AIResponse aiResponse = objectMapper.readValue(aiResponseContent, AIResponse.class);

            // Convert to DTO using adapter
            return procurementAdapter.convertToDto(aiResponse);

        } catch (Exception e) {
            log.error("Failed to generate procurement from AI", e);
            throw new RuntimeException("Failed to generate procurement: " + e.getMessage(), e);
        }
    }

    private String buildPrompt(String textQuery) {
        return """
                Extract procurement information from the following text and return ONLY a valid JSON object with these fields:
                - procurement: object with these fields:
                  - name: procurement name (string)
                  - description: detailed description (string)
                  - status: one of [DRAFT, PENDING, APPROVED, REJECTED] (string)
                  - budget: estimated budget as number (no currency symbols)
                  - deadlineDays: number of days from now (integer)
                  - properties: object with priority (high/medium/low), department, category
                - products: array of product objects, each with:
                  - name: product name (string)
                  - quantity: quantity needed (integer)
                  - properties: object with any relevant product details

                Text: %s

                Return ONLY the JSON object with procurement and products, no markdown or explanation.
                Example format:
                {
                  "procurement": { "name": "...", "description": "...", ... },
                  "products": [{ "name": "...", "quantity": 10, ... }]
                }
                """.formatted(textQuery);
    }
}
