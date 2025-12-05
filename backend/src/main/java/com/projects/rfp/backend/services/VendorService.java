package com.projects.rfp.backend.services;

import com.projects.rfp.backend.adapters.VendorAdapter;
import com.projects.rfp.backend.repositories.VendorRepository;
import com.projects.rfp.backend.requests.CreateVendorRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VendorService {
    private final VendorRepository vendorRepository;
    private final VendorAdapter vendorAdapter;

    public void createVendor(CreateVendorRequest request){
        vendorRepository.save(vendorAdapter.convert(request));
    }

    public void deleteVendorById(String vendorId){
        vendorRepository.deleteById(vendorId);
    }
}
