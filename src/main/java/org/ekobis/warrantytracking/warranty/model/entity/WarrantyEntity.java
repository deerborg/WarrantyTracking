package org.ekobis.warrantytracking.warranty.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;

@Entity
@Table(name = "warranty")
@Getter
@Setter
public class WarrantyEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;

    @Temporal(TemporalType.DATE)
    private LocalDate purchaseDate;

    private String warrantyStatus;

    private String deviceId;
}
