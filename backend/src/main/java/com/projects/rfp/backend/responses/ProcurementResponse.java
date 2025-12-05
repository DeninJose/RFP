package com.projects.rfp.backend.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProcurementResponse {

    private String status;

    private String message;

    private String procurementId;

    private Object parsedData;
}
