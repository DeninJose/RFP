package com.projects.rfp.backend.controllers;

import com.projects.rfp.backend.requests.CreateVendorRequest;
import com.projects.rfp.backend.services.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vendors")
@RequiredArgsConstructor
public class VendorController {
    private final VendorService vendorService;

    @PostMapping
    public void createVendor(@RequestBody CreateVendorRequest request){
        vendorService.createVendor(request);
    }

    @DeleteMapping("/{vendorId}")
    public void deleteVendorById(@PathVariable String vendorId){
        vendorService.deleteVendorById(vendorId);
    }

}
