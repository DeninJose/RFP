package com.projects.rfp.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AIResponse {
    private AIProcurementRequest procurement;
    private List<AIProductRequest> products;
}

