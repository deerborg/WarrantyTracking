package org.ekobis.warrantytracking.device.service.impl;

import lombok.RequiredArgsConstructor;
import org.ekobis.warrantytracking.common.result.DataResponse;
import org.ekobis.warrantytracking.device.model.dto.request.CreateDeviceRequest;
import org.ekobis.warrantytracking.device.model.dto.request.UpdateDeviceRequest;
import org.ekobis.warrantytracking.device.model.dto.response.DeviceResponse;
import org.ekobis.warrantytracking.device.model.entity.DeviceEntity;
import org.ekobis.warrantytracking.device.model.mapper.DeviceMapper;
import org.ekobis.warrantytracking.device.model.util.excepiton.NotFoundDeviceId;
import org.ekobis.warrantytracking.device.model.util.helper.GeneratedSerialNumber;
import org.ekobis.warrantytracking.device.repository.DeviceRepository;
import org.ekobis.warrantytracking.device.service.DeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;
    private final DeviceMapper deviceMapper;

    @Override
    public ResponseEntity<DataResponse<DeviceResponse>> createDevice(CreateDeviceRequest createDeviceRequest) {

        DeviceEntity deviceEntity = deviceMapper.toCreateDeviceRequest(createDeviceRequest);

        deviceEntity.setSerialNumber(GeneratedSerialNumber.generateSerialNumber(
                        deviceEntity.getBrand(),
                        deviceEntity.getModel()
                )
        );

        DeviceResponse responseData = deviceMapper.fromDeviceEntity(deviceRepository.save(deviceEntity));

        return new ResponseEntity<>(new DataResponse<>( "Device Created", responseData), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<DataResponse<DeviceResponse>> updateDevice(UpdateDeviceRequest updateDeviceRequest) {

        if (!deviceRepository.existsById(updateDeviceRequest.getId())) {
            throw new NotFoundDeviceId("Not Found ID : " + updateDeviceRequest.getId());
        }

        DeviceEntity deviceEntity = deviceMapper.toUpdateDeviceRequest(updateDeviceRequest);

        DeviceResponse response = deviceMapper.fromDeviceEntity(deviceRepository.save(deviceEntity));

        return new ResponseEntity<>(new DataResponse<>("Device Updated", response), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataResponse<List<DeviceResponse>>> getAllDevices() {

        List<DeviceResponse> deviceList = deviceRepository.findAll()
                .stream().map(deviceMapper::fromDeviceEntity).toList();

        return new ResponseEntity<>(new DataResponse<>("Device List", deviceList), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataResponse<DeviceResponse>> getDevice(String deviceId) {

        DeviceEntity device = deviceRepository.findById(deviceId).orElseThrow(() -> new NotFoundDeviceId("Not Found ID : " + deviceId));

        DeviceResponse responseData = deviceMapper.fromDeviceEntity(device);

        return new ResponseEntity<>(new DataResponse<>("Device Found", responseData), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteDeviceById(String deviceId) {

        if(!deviceRepository.existsById(deviceId)) {
            throw new NotFoundDeviceId("Not Found ID : " + deviceId);
        }

        deviceRepository.deleteById(deviceId);

        return new ResponseEntity<>("Device Deleted", HttpStatus.OK);

    }
}
