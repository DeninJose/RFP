package com.projects.rfp.backend.adapters;

import com.projects.rfp.backend.dtos.AIResponse;
import com.projects.rfp.backend.dtos.ProcurementDto;
import com.projects.rfp.backend.entities.Procurement;
import com.projects.rfp.backend.entities.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProcurementAdapter {

    public ProcurementDto convertToDto(AIResponse aiResponse) {
        String procurementId = "PROC-" + System.currentTimeMillis();
        long currentTime = System.currentTimeMillis();

        // Convert AI procurement to entity
        Procurement procurement = Procurement.builder()
                .procurementId(procurementId)
                .name(aiResponse.getProcurement().getName())
                .description(aiResponse.getProcurement().getDescription())
                .status(aiResponse.getProcurement().getStatus() != null ?
                        aiResponse.getProcurement().getStatus() : "DRAFT")
                .budget(aiResponse.getProcurement().getBudget() != null ?
                        aiResponse.getProcurement().getBudget() : 0)
                .deadline(currentTime + (aiResponse.getProcurement().getDeadlineDays() != null ?
                        aiResponse.getProcurement().getDeadlineDays() : 30L) * 24 * 60 * 60 * 1000)
                .properties(aiResponse.getProcurement().getProperties())
                .createdAt(currentTime)
                .updatedAt(currentTime)
                .build();

        // Convert AI products to entities
        List<Product> products = aiResponse.getProducts().stream()
                .map(aiProduct -> Product.builder()
                        .productId("PROD-" + System.currentTimeMillis() + "-" + Math.random())
                        .procurementId(procurementId)
                        .name(aiProduct.getName())
                        .quantity(aiProduct.getQuantity() != null ? aiProduct.getQuantity() : 1)
                        .properties(aiProduct.getProperties())
                        .createdAt(currentTime)
                        .updatedAt(currentTime)
                        .build())
                .collect(Collectors.toList());

        return ProcurementDto.builder()
                .procurement(procurement)
                .products(products)
                .build();
    }
}
