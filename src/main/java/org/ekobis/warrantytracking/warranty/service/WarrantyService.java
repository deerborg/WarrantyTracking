package org.ekobis.warrantytracking.warranty.service;

import org.ekobis.warrantytracking.common.result.DataResponse;
import org.ekobis.warrantytracking.warranty.model.dto.request.AddWarrantRequest;
import org.ekobis.warrantytracking.warranty.model.dto.request.UpdateWarrantRequest;
import org.ekobis.warrantytracking.warranty.model.dto.response.WarrantyResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface WarrantyService {

    ResponseEntity<DataResponse<WarrantyResponse>> addWarranty(AddWarrantRequest warrantRequest);

    ResponseEntity<DataResponse<WarrantyResponse>> updateWarranty(UpdateWarrantRequest warrantRequest);

    ResponseEntity<DataResponse<WarrantyResponse>> getByWarrantyId(String warrantyId);

    ResponseEntity<DataResponse<List<WarrantyResponse>>> getAllWarranty();

    ResponseEntity<String> deleteWarrantyByWarrantyId(String warrantyId);
}
