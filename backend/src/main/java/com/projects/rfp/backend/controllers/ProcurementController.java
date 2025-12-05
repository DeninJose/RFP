package com.projects.rfp.backend.controllers;

import com.projects.rfp.backend.entities.Procurement;
import com.projects.rfp.backend.requests.ProcurementRequest;
import com.projects.rfp.backend.services.ProcurementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/procurements")
@RequiredArgsConstructor
public class ProcurementController {

    private final ProcurementService procurementService;

    @PostMapping
    public void createProcurement(@RequestBody ProcurementRequest request) {
        procurementService.createProcurement(request.getQueryText());
    }

    @GetMapping
    public List<Procurement> getAllProcurements(){
        return procurementService.getAllProcurements();
    }

    @DeleteMapping
    public void deleteAllProcurements(){
        // For testing purposes only
        procurementService.deleteAllProcurements();
    }
}

