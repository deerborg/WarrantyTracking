package org.ekobis.warrantytracking.device.model.mapper;

import org.ekobis.warrantytracking.device.model.dto.request.CreateDeviceRequest;
import org.ekobis.warrantytracking.device.model.dto.request.UpdateDeviceRequest;
import org.ekobis.warrantytracking.device.model.dto.response.DeviceResponse;
import org.ekobis.warrantytracking.device.model.entity.DeviceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeviceMapper {

    // For Request

    DeviceEntity toCreateDeviceRequest(CreateDeviceRequest createDeviceRequest);

    DeviceEntity toUpdateDeviceRequest(UpdateDeviceRequest updateDeviceRequest);

    // For Response

    DeviceResponse fromDeviceEntity(DeviceEntity deviceEntity);

}
