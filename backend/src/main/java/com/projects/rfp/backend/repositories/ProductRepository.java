package com.projects.rfp.backend.repositories;

import com.projects.rfp.backend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    List<Product> findByProcurementId(String procurementId);

    void deleteByProcurementId(String procurementId);
}

