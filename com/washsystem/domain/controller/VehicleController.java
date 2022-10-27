package com.washsystem.domain.controller;

import com.washsystem.domain.exception.EntityHasScheduledServicesException;
import com.washsystem.domain.exception.EntityNotFoundException;
import com.washsystem.domain.model.Category;
import com.washsystem.domain.model.Vehicle;
import com.washsystem.domain.persistence.VehiclePersistence;

public class VehicleController {

    private final CategoryController categoryController;
    private final VehiclePersistence vehiclePersistence;
    private final ScheduleController scheduleController;

    public VehicleController(
        CategoryController categoryController,
        VehiclePersistence vehiclePersistence,
        ScheduleController scheduleController
    ) {
        this.categoryController = categoryController;
        this.vehiclePersistence = vehiclePersistence;
        this.scheduleController = scheduleController;
    }

    public void registerVehicle(String plate, String model, String brand, String categoryName) {
        Category category = this.categoryController.findOneByName(categoryName);

        Vehicle vehicle = new Vehicle(plate, model, brand, category.getId());

        this.vehiclePersistence.create(vehicle);
    }

    public Vehicle findOneByPlate(String plate) {
        Vehicle vehicle = this.vehiclePersistence.findOneByPlate(plate);

        if (vehicle == null) {
            throw new EntityNotFoundException();
        }

        return vehicle;
    }

    public void editVehicle(Long id, String plate, String model, String brand, String categoryName) {
        Category category = this.categoryController.findOneByName(categoryName);

        Vehicle vehicle = new Vehicle(id, plate, model, brand, category.getId());

        this.vehiclePersistence.save(vehicle);
    }

    public void deleteVehicle(Long id) throws EntityHasScheduledServicesException {
        if (!this.scheduleController.verifyVehicleSchedule(id)) {
            this.vehiclePersistence.delete(id);
        } else {
            throw new EntityHasScheduledServicesException();
        }
    }
}
