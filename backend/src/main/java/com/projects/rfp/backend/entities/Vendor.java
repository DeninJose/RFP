package com.projects.rfp.backend.entities;

import com.projects.rfp.backend.enums.VendorStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.Map;

@Entity
@Table(name = "vendors")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vendor {
    @Id
    private String vendorId;

    @Column(nullable = false, unique = true)
    private String name;
    private String email;
    private String phone;
    private String website;
    private List<String> categories;
    @Enumerated(EnumType.STRING)
    private VendorStatus status;  // ACTIVE, INACTIVE, BLACKLISTED
    private Double rating;  // 0.0 to 5.0

    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, String> additionalInfo;

    private Long createdAt;
    private Long updatedAt;
}
