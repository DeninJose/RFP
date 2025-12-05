package com.projects.rfp.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AIProductRequest {
    private String name;
    private Integer quantity;
    private Map<String, String> properties;
}
