package com.washsystem.infrastructure.persistence.repository;

import com.washsystem.infrastructure.persistence.entity.VehicleEntity;

public interface VehicleRepository extends CommonRepository<Long, VehicleEntity> {

    VehicleEntity findOneByPlate(String plate);
}
