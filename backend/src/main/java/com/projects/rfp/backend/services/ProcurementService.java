package com.projects.rfp.backend.services;

import com.projects.rfp.backend.entities.Procurement;
import com.projects.rfp.backend.repositories.ProcurementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProcurementService {

    private final ProcurementRepository procurementRepository;

    public Procurement createProcurement(String textQuery) {
        // Get Procurement from AI;
        // Put in DB
        Procurement mockProcurement = Procurement.builder()
                .procurementId("PROC-2024-001")
                .name("Office Furniture Procurement")
                .description("Purchase of ergonomic office chairs and desks for new headquarters")
                .status("PENDING")
                .budget(50000)
                .deadline(System.currentTimeMillis() + (30L * 24 * 60 * 60 * 1000)) // 30 days from now
                .properties(Map.of(
                        "priority", "high",
                        "department", "IT",
                        "approver", "john.doe@company.com",
                        "category", "furniture"
                ))
                .createdAt(System.currentTimeMillis())
                .updatedAt(System.currentTimeMillis())
                .build();
        procurementRepository.save(mockProcurement);
        return mockProcurement;
    }

    public List<Procurement> getAllProcurements(){
        return procurementRepository.findAll();
    }

    public void deleteAllProcurements(){
        procurementRepository.deleteAll();
    }
}
