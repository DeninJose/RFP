package com.projects.rfp.backend.dtos;

import com.projects.rfp.backend.entities.Procurement;
import com.projects.rfp.backend.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProcurementDto {
    private Procurement procurement;
    private List<Product> products;
}
