package com.projects.rfp.backend.entities;

import com.projects.rfp.backend.enums.VendorStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

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

    private String name;
    private String email;
    private String phone;
    private String website;

    @Enumerated(EnumType.STRING)
    private VendorStatus status;  // ACTIVE, INACTIVE, BLACKLISTED

    private Double rating;  // 0.0 to 5.0

    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, String> contactInfo;  // address, city, country, etc.

    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, String> categories;  // IT_EQUIPMENT, OFFICE_SUPPLIES, etc.

    private Long createdAt;
    private Long updatedAt;
}
