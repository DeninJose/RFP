package com.projects.rfp.backend.services;

import com.projects.rfp.backend.adapters.VendorAdapter;
import com.projects.rfp.backend.entities.Vendor;
import com.projects.rfp.backend.repositories.VendorRepository;
import com.projects.rfp.backend.requests.CreateVendorRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VendorService {
    private final VendorRepository vendorRepository;
    private final VendorAdapter vendorAdapter;

    public void createVendor(CreateVendorRequest request){
        vendorRepository.save(vendorAdapter.convert(request));
    }

    public List<Vendor> getAllVendors(){
        return vendorRepository.findAll();
    }

    public void deleteVendorById(String vendorId){
        vendorRepository.deleteById(vendorId);
    }
}
