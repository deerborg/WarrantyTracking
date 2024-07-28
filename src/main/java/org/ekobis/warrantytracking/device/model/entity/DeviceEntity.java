package org.ekobis.warrantytracking.device.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "device")
@Setter
@Getter
public class DeviceEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;

    @Column(unique = true)
    private String serialNumber;

    private String brand;

    private String model;

}
