package com.washsystem.infrastructure.persistence;

import com.washsystem.domain.model.Vehicle;
import com.washsystem.domain.persistence.VehiclePersistence;
import com.washsystem.infrastructure.persistence.provider.LongIdProvider;

import java.util.List;

public class VehicleHashMapPersistence extends CommonHashMapPersistence<Long, Vehicle, LongIdProvider> implements VehiclePersistence {

    public VehicleHashMapPersistence() {
        super(new LongIdProvider());
    }

    @Override
    public Vehicle findOneByPlate(String plate) {
        return this.findOneByValue(plate, Vehicle::getPlate);
    }
}