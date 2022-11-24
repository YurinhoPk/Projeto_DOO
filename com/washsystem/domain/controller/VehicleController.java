package com.washsystem.domain.controller;

import com.washsystem.domain.exception.EntityHasScheduledServicesException;
import com.washsystem.domain.exception.EntityNotFoundException;
import com.washsystem.domain.model.Category;
import com.washsystem.domain.model.Vehicle;
import com.washsystem.domain.persistence.VehiclePersistence;

public class VehicleController {

    private final VehiclePersistence vehiclePersistence;
    private CategoryController categoryController;
    private ScheduleController scheduleController;

    public VehicleController(VehiclePersistence vehiclePersistence) {
        this.vehiclePersistence = vehiclePersistence;
    }

    public void setCategoryController(CategoryController categoryController) {
        this.categoryController = categoryController;
    }

    public void setScheduleController(ScheduleController scheduleController) {
        this.scheduleController = scheduleController;
    }

    public void registerVehicle(String plate, String model, String brand, String categoryName) {
        Category category = this.categoryController.findOneByName(categoryName);

        Vehicle vehicle = new Vehicle(plate, model, brand, category);

        this.vehiclePersistence.create(vehicle);
    }

    public Vehicle findOneByPlate(String plate) throws EntityNotFoundException {
        Vehicle vehicle = this.vehiclePersistence.findOneByPlate(plate);

        if (vehicle != null) {
            return vehicle;
        } else {
            throw new EntityNotFoundException("Nao existe Veiculo com placa " + plate);
        }
    }

    public void editVehicle(Long id, String plate, String model, String brand, String categoryName) throws EntityNotFoundException {
        Category category = this.categoryController.findOneByName(categoryName);

        if (category != null) {
            Vehicle vehicle = new Vehicle(id, plate, model, brand, category);
            this.vehiclePersistence.save(vehicle);
        } else {
            throw new EntityNotFoundException("Nao existe Veiculo com id " + id);
        }
    }

    public void deleteVehicle(Long id) throws EntityHasScheduledServicesException {
        if (!this.scheduleController.verifyVehicleSchedule(id)) {
            this.vehiclePersistence.delete(id);
        } else {
            throw new EntityHasScheduledServicesException();
        }
    }
}
