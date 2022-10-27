package com.washsystem.domain.persistence;

import com.washsystem.domain.model.Vehicle;

import java.util.List;

public interface VehiclePersistence extends CommonPersistence<Long, Vehicle> {

    Vehicle findOneByPlate(String plate);
}
