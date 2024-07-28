package org.ekobis.warrantytracking.warranty.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ekobis.warrantytracking.common.result.DataResponse;
import org.ekobis.warrantytracking.warranty.model.dto.request.AddWarrantRequest;
import org.ekobis.warrantytracking.warranty.model.dto.request.UpdateWarrantRequest;
import org.ekobis.warrantytracking.warranty.model.dto.response.WarrantyResponse;
import org.ekobis.warrantytracking.warranty.service.WarrantyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warranty")
@RequiredArgsConstructor
public class WarrantyController {

    private final WarrantyService warrantyService;

    @PostMapping
    public ResponseEntity<DataResponse<WarrantyResponse>> createWarranty(@Valid @RequestBody AddWarrantRequest warranty) {
        return warrantyService.addWarranty(warranty);
    }

    @PutMapping
    public ResponseEntity<DataResponse<WarrantyResponse>> updateWarranty(@Valid @RequestBody UpdateWarrantRequest warranty) {
        return warrantyService.updateWarranty(warranty);
    }

    @GetMapping("/{warrantyId}")
    public ResponseEntity<DataResponse<WarrantyResponse>> getByWarrantyId(@PathVariable String warrantyId) {
        return warrantyService.getByWarrantyId(warrantyId);
    }

    @GetMapping
    public ResponseEntity<DataResponse<List<WarrantyResponse>>> getAllWarranty() {
        return warrantyService.getAllWarranty();
    }

    @DeleteMapping("/{warrantyId}")
    public ResponseEntity<String> deleteWarranty(@PathVariable String warrantyId) {
        return warrantyService.deleteWarrantyByWarrantyId(warrantyId);
    }
}
