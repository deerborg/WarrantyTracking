package org.ekobis.warrantytracking.device.model.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateDeviceRequest {

    @NotBlank
    private String id;

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

}
