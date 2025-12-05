package com.projects.rfp.backend.utils;

import org.springframework.stereotype.Component;

@Component
public class IdGenerator {
    public String getProcurementId(){
        return "PROC-" + System.currentTimeMillis();
    }

    public String getProductId(){
        return "PROD-" + System.currentTimeMillis();
    }

    public String getVendorId(){
        return "VEND-" + System.currentTimeMillis();
    }
}
