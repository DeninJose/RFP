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
@Table(name = "procurements")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Procurement {
    @Id
    private String procurementId;
    private String name;
    private String description;
    private String status;
    private Integer budget;
    private Long deadline;

    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, String> properties;

    private Long createdAt;
    private Long updatedAt;
}