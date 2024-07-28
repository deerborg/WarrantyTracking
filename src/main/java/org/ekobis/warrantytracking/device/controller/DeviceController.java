package org.ekobis.warrantytracking.device.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ekobis.warrantytracking.common.result.DataResponse;
import org.ekobis.warrantytracking.device.model.dto.request.CreateDeviceRequest;
import org.ekobis.warrantytracking.device.model.dto.request.UpdateDeviceRequest;
import org.ekobis.warrantytracking.device.model.dto.response.DeviceResponse;
import org.ekobis.warrantytracking.device.service.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/device")
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;

    @PostMapping
    public ResponseEntity<DataResponse<DeviceResponse>> createDevice(@Valid @RequestBody CreateDeviceRequest createDeviceRequest) {

        return deviceService.createDevice(createDeviceRequest);
    }

    @PutMapping
    public ResponseEntity<DataResponse<DeviceResponse>> updateDevice(@Valid @RequestBody UpdateDeviceRequest updateDeviceRequest) {

        return deviceService.updateDevice(updateDeviceRequest);
    }

    @GetMapping
    public ResponseEntity<DataResponse<List<DeviceResponse>>> getAllDevices() {

        return deviceService.getAllDevices();
    }

    @GetMapping("/{deviceId}")
    public ResponseEntity<DataResponse<DeviceResponse>> getDeviceById(@PathVariable("deviceId") String deviceId) {

        return deviceService.getDevice(deviceId);
    }

    @DeleteMapping("/{deviceId}")
    public ResponseEntity<String> deleteDevice(@PathVariable("deviceId") String deviceId) {

        return deviceService.deleteDeviceById(deviceId);
    }


}
