package com.projects.rfp.backend.services;

import com.projects.rfp.backend.entities.Product;
import com.projects.rfp.backend.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public void saveProducts(List<Product> products) {
        if (products != null && !products.isEmpty()) {
            productRepository.saveAll(products);
            log.info("Saved {} products", products.size());
        }
    }

    public List<Product> getProductsByProcurementId(String procurementId) {
        return productRepository.findByProcurementId(procurementId);
    }

    @Transactional
    public void deleteAllProducts() {
        productRepository.deleteAll();
        log.info("Deleted all products");
    }
}
