package org.ekobis.warrantytracking.device.repository;

import org.ekobis.warrantytracking.device.model.entity.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceEntity,String> {
}
