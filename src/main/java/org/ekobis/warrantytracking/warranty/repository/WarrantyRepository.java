package org.ekobis.warrantytracking.warranty.repository;

import org.ekobis.warrantytracking.warranty.model.entity.WarrantyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarrantyRepository extends JpaRepository<WarrantyEntity,String> {
    boolean existsByDeviceId(String deviceId);
}
