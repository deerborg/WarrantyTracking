package org.ekobis.warrantytracking.device.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeviceResponse {

    private String id;

    private String serialNumber;

    private String brand;

    private String model;

}
