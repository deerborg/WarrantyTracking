package org.ekobis.warrantytracking.warranty.service.impl;

import lombok.RequiredArgsConstructor;
import org.ekobis.warrantytracking.common.result.DataResponse;
import org.ekobis.warrantytracking.device.model.util.excepiton.NotFoundDeviceId;
import org.ekobis.warrantytracking.device.repository.DeviceRepository;
import org.ekobis.warrantytracking.warranty.model.dto.request.AddWarrantRequest;
import org.ekobis.warrantytracking.warranty.model.dto.request.UpdateWarrantRequest;
import org.ekobis.warrantytracking.warranty.model.dto.response.WarrantyResponse;
import org.ekobis.warrantytracking.warranty.model.entity.WarrantyEntity;
import org.ekobis.warrantytracking.warranty.model.mapper.WarrantyMapper;
import org.ekobis.warrantytracking.warranty.model.util.exception.ExistingDeviceException;
import org.ekobis.warrantytracking.warranty.model.util.exception.NotFoundWarrantId;
import org.ekobis.warrantytracking.warranty.model.util.helper.CheckWarrantStatus;
import org.ekobis.warrantytracking.warranty.repository.WarrantyRepository;
import org.ekobis.warrantytracking.warranty.service.WarrantyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarrantyServiceImpl implements WarrantyService {

    private final WarrantyRepository warrantyRepository;
    private final DeviceRepository deviceRepository;
    private final WarrantyMapper warrantyMapper;

    @Override
    public ResponseEntity<DataResponse<WarrantyResponse>> addWarranty(AddWarrantRequest warrantRequest) {

        WarrantyEntity warrantyEntity = warrantyMapper.toAddWarrantRequest(warrantRequest);


        if(!deviceRepository.existsById(warrantyEntity.getDeviceId())) {
            throw new NotFoundDeviceId("Not Found Device ID: " + warrantyEntity.getDeviceId());
        }

        if(warrantyRepository.existsByDeviceId(warrantyEntity.getDeviceId())) {
            throw new ExistingDeviceException("Device Warranty already exists!");
        }

        String warrantyStatus = CheckWarrantStatus.checkStatus(warrantyEntity.getPurchaseDate());

        warrantyEntity.setWarrantyStatus(warrantyStatus);

        WarrantyResponse warrantyResponse = warrantyMapper.fromAddWarrantRequest(warrantyRepository.save(warrantyEntity));

        return new ResponseEntity<>(new DataResponse<>("Added warrant for device",warrantyResponse), HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<DataResponse<WarrantyResponse>> updateWarranty(UpdateWarrantRequest warrantRequest) {

        if(!warrantyRepository.existsById(warrantRequest.getId())){
            throw new NotFoundWarrantId("Not Found Warrant ID: " + warrantRequest.getId());
        }

        WarrantyEntity warrantyEntity = warrantyMapper.toUpdateWarrantRequest(warrantRequest);

        if(!deviceRepository.existsById(warrantyEntity.getDeviceId())) {
            throw new NotFoundDeviceId("Not Found Device ID: " + warrantyEntity.getDeviceId());
        }

        String warrantyStatus = CheckWarrantStatus.checkStatus(warrantyEntity.getPurchaseDate());

        warrantyEntity.setWarrantyStatus(warrantyStatus);

        WarrantyResponse warrantyResponse = warrantyMapper.fromAddWarrantRequest(warrantyRepository.save(warrantyEntity));

        return new ResponseEntity<>(new DataResponse<>("Update Warranty for Device",warrantyResponse), HttpStatus.OK);


    }

    @Override
    public ResponseEntity<DataResponse<WarrantyResponse>> getByWarrantyId(String warrantyId) {

        WarrantyEntity warrantyEntity = warrantyRepository.findById(warrantyId).orElseThrow(
                () -> new NotFoundWarrantId("Not Found Warrant ID: " + warrantyId));

        WarrantyResponse warrantyResponse = warrantyMapper.fromAddWarrantRequest(warrantyEntity);

        return new ResponseEntity<>(new DataResponse<>("Warranty Found",warrantyResponse),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataResponse<List<WarrantyResponse>>> getAllWarranty() {

        List<WarrantyResponse> warrantyResponses = warrantyRepository.findAll().stream()
                .map(warrantyMapper::fromAddWarrantRequest).toList();

        return new ResponseEntity<>(new DataResponse<>("Warranty List",warrantyResponses), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteWarrantyByWarrantyId(String warrantyId) {

        if(warrantyRepository.existsById(warrantyId)) {

            warrantyRepository.deleteById(warrantyId);

            return new ResponseEntity<>("Warranty Deleted Successfully", HttpStatus.OK);
        }

        throw new NotFoundWarrantId("Not Found Warrant ID: " + warrantyId);
    }
}

