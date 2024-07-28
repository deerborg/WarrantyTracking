package org.ekobis.warrantytracking.device.service;

import org.ekobis.warrantytracking.common.result.DataResponse;
import org.ekobis.warrantytracking.device.model.dto.request.CreateDeviceRequest;
import org.ekobis.warrantytracking.device.model.dto.request.UpdateDeviceRequest;
import org.ekobis.warrantytracking.device.model.dto.response.DeviceResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DeviceService {

    ResponseEntity<DataResponse<DeviceResponse>> createDevice(CreateDeviceRequest createDeviceRequest);

    ResponseEntity<DataResponse<DeviceResponse>> updateDevice(UpdateDeviceRequest updateDeviceRequest);

    ResponseEntity<DataResponse<List<DeviceResponse>>> getAllDevices();

    ResponseEntity<DataResponse<DeviceResponse>> getDevice(String deviceId);

    ResponseEntity<String> deleteDeviceById(String deviceId);

}
