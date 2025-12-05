package com.projects.rfp.backend.services;

import com.projects.rfp.backend.dtos.ProcurementDto;
import com.projects.rfp.backend.entities.Procurement;
import com.projects.rfp.backend.repositories.ProcurementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProcurementService {

    private final ProcurementRepository procurementRepository;
    private final ProductService productService;
    private final AIService aiService;

    @Transactional
    public ProcurementDto createProcurement(String textQuery) {
        log.info("Creating procurement from text query");

        // Get ProcurementDto from AI (includes procurement and products)
        ProcurementDto dto = aiService.generateProcurementFromText(textQuery);

        // Save procurement
        procurementRepository.save(dto.getProcurement());
        log.info("Saved procurement: {}", dto.getProcurement().getProcurementId());

        // Save products through ProductService
        productService.saveProducts(dto.getProducts());
        return dto;
    }

    public List<Procurement> getAllProcurements(){
        return procurementRepository.findAll();
    }

    public ProcurementDto getProcurementById(String procurementId){
        Procurement procurement = procurementRepository.findById(procurementId)
                .orElseThrow(() -> new RuntimeException("Procurement not found with id: " + procurementId));
        var products = productService.getProductsByProcurementId(procurementId);
        return ProcurementDto.builder()
                .procurement(procurement)
                .products(products)
                .build();
    }

    @Transactional
    public void deleteAllProcurements(){
        procurementRepository.deleteAll();
        productService.deleteAllProducts();
    }
}
