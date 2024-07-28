package org.ekobis.warrantytracking.device.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateDeviceRequest {
    @NotBlank
    private String brand;

    @NotBlank
    private String model;

}
