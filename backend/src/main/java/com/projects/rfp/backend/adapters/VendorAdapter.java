package com.projects.rfp.backend.adapters;

import com.projects.rfp.backend.entities.Vendor;
import com.projects.rfp.backend.requests.CreateVendorRequest;
import com.projects.rfp.backend.utils.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VendorAdapter {
    private final IdGenerator idGenerator;
    public Vendor convert(CreateVendorRequest request){
        return Vendor.builder()
                .vendorId(idGenerator.getVendorId())
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .website(request.getWebsite())
                .status(request.getStatus())
                .rating(request.getRating())
                .additionalInfo(request.getAdditionalInfo())
                .createdAt(System.currentTimeMillis())
                .updatedAt(System.currentTimeMillis())
                .build();
    }
}
