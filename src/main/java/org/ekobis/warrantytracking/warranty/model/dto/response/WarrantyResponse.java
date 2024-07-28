package org.ekobis.warrantytracking.warranty.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WarrantyResponse {

    private String id;

    private LocalDate purchaseDate;

    private String warrantyStatus;

    private String deviceId;

}
