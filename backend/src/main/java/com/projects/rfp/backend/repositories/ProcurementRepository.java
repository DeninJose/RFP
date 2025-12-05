package com.projects.rfp.backend.repositories;

import com.projects.rfp.backend.entities.Procurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcurementRepository extends JpaRepository<Procurement, String> {
    // Automatically provided by JpaRepository:
    // - save(Procurement)
    // - findById(String)
    // - findAll()
    // - deleteById(String)
    // - count()
    // - existsById(String)
}
