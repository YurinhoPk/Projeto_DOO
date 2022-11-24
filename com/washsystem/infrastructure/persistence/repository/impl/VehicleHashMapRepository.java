package com.washsystem.infrastructure.persistence.repository.impl;

import com.washsystem.infrastructure.persistence.entity.VehicleEntity;
import com.washsystem.infrastructure.persistence.provider.LongIdProvider;
import com.washsystem.infrastructure.persistence.repository.VehicleRepository;

public class VehicleHashMapRepository extends CommonHashMapRepository<Long, VehicleEntity, LongIdProvider> implements VehicleRepository {

    public VehicleHashMapRepository() {
        super(new LongIdProvider());
    }

    @Override
    public VehicleEntity findOneByPlate(String plate) {
        return this.findOneByValue(plate, VehicleEntity::getPlate);
    }
}