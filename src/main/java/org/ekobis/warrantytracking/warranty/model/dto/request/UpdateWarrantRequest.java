package org.ekobis.warrantytracking.warranty.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateWarrantRequest {

    @NotBlank
    private String id;

    @NotNull
    private LocalDate purchaseDate;

    @NotBlank
    private String deviceId;
}
