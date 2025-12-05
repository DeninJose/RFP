package com.projects.rfp.backend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AIProcurementRequest {
    private String name;
    private String description;
    private String status;
    private Integer budget;
    private Long deadlineDays;
    private Map<String, String> properties;
}

