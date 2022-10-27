package com.washsystem.domain.controller;

import com.washsystem.domain.exception.EntityHasScheduledServicesException;
import com.washsystem.domain.exception.EntityNotFoundException;
import com.washsystem.domain.model.Service;
import com.washsystem.domain.model.Vehicle;
import com.washsystem.domain.persistence.ServicePersistence;

public class ServiceController {

    private final ServicePersistence servicePersistence;
    private final ScheduleController scheduleController;
    private final VehicleController vehicleControlle;

    public ServiceController(
        ServicePersistence servicePersistence,
        ScheduleController scheduleController,
        VehicleController vehicleControlle
    ) {
        this.servicePersistence = servicePersistence;
        this.scheduleController = scheduleController;
        this.vehicleControlle = vehicleControlle;
    }

    public void registerService(String plate, String type, String description) {
        Vehicle vehicle = this.vehicleControlle.findOneByPlate(plate);

        Service service = new Service(vehicle.getId(), type, description);

        this.servicePersistence.create(service);
    }

    public Service findById(Long id) throws EntityNotFoundException {
        Service service = this.servicePersistence.findById(id);

        if (service != null) {
            return service;
        } else {
            throw new EntityNotFoundException();
        }
    }

    public void editService(Long id, String plate, String type, String description) {
        Vehicle vehicle = this.vehicleControlle.findOneByPlate(plate);

        Service service = new Service(id, vehicle.getId(), type, description);

        this.servicePersistence.save(service);
    }

    public void deleteService(Long id) throws EntityHasScheduledServicesException {
        if (!this.scheduleController.verifyServiceSchedule(id)) {
            this.servicePersistence.delete(id);
        } else {
            throw new EntityHasScheduledServicesException();
        }
    }
}
