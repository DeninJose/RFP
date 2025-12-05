package com.projects.rfp.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;

@Entity
@Table(name = "products")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private String productId;
    private String procurementId;
    private String name;
    private Integer quantity;
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, String> properties;
    private Long createdAt;
    private Long updatedAt;
}
