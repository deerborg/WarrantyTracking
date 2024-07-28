package org.ekobis.warrantytracking.warranty.model.mapper;

import org.ekobis.warrantytracking.warranty.model.dto.request.AddWarrantRequest;
import org.ekobis.warrantytracking.warranty.model.dto.request.UpdateWarrantRequest;
import org.ekobis.warrantytracking.warranty.model.dto.response.WarrantyResponse;
import org.ekobis.warrantytracking.warranty.model.entity.WarrantyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WarrantyMapper {

    WarrantyEntity toAddWarrantRequest(AddWarrantRequest addWarrantRequest);

    WarrantyEntity toUpdateWarrantRequest(UpdateWarrantRequest updateWarrantRequest);

    WarrantyResponse fromAddWarrantRequest(WarrantyEntity warrantyEntity);

}
