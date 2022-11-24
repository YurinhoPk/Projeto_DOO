package com.washsystem.infrastructure.persistence.mapper;

import com.washsystem.domain.model.Vehicle;
import com.washsystem.infrastructure.persistence.entity.VehicleEntity;

public class VehicleMapper implements Mapper<Long, Vehicle, VehicleEntity> {

    @Override
    public Vehicle toModel(VehicleEntity vehicleEntity) {
        return new Vehicle(
            vehicleEntity.getId(),
            vehicleEntity.getPlate(),
            vehicleEntity.getModel(),
            vehicleEntity.getBrand(),
            null
        );
    }

    @Override
    public VehicleEntity toEntity(Vehicle vehicle) {
        return new VehicleEntity(
            vehicle.getId(),
            vehicle.getPlate(),
            vehicle.getModel(),
            vehicle.getBrand(),
            null
        );
    }
}
