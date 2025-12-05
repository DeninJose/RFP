package com.projects.rfp.backend.requests;

import com.projects.rfp.backend.enums.VendorStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateVendorRequest {
    private String name;
    private String email;
    private String phone;
    private String website;
    private VendorStatus status;
    private Double rating;
    private Map<String, String> additionalInfo;
}
