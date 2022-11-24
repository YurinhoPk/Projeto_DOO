package com.washsystem.domain.controller;

import com.washsystem.domain.exception.EntityHasScheduledServicesException;
import com.washsystem.domain.exception.EntityNotFoundException;
import com.washsystem.domain.model.Service;
import com.washsystem.domain.model.Vehicle;
import com.washsystem.domain.persistence.ServicePersistence;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ServiceController {

    private final ServicePersistence servicePersistence;
    private ScheduleController scheduleController;
    private VehicleController vehicleController;

    public ServiceController(ServicePersistence servicePersistence) {
        this.servicePersistence = servicePersistence;
    }

    public void setScheduleController(ScheduleController scheduleController) {
        this.scheduleController = scheduleController;
    }

    public void setVehicleController(VehicleController vehicleController) {
        this.vehicleController = vehicleController;
    }

    public Service registerService(String plate, String type, String description) {
        Vehicle vehicle = this.vehicleController.findOneByPlate(plate);

        Service service = new Service(vehicle, type, description);

        return this.servicePersistence.create(service);
    }

    public Service findById(Long id) throws EntityNotFoundException {
        Service service = this.servicePersistence.findById(id);

        if (service != null) {
            return service;
        } else {
            throw new EntityNotFoundException("Nao existe Servico com id " + id);
        }
    }

    public Service findByPlateAndType(String plate, String type) throws EntityNotFoundException {
        Vehicle vehicle = this.vehicleController.findOneByPlate(plate);
        Service service = this.servicePersistence.findByVehicleIdAndType(vehicle.getId(), type);

        if (service != null) {
            return service;
        } else {
            throw new EntityNotFoundException("Nao existe Servico " + type + " para o Veiculo de placa " + plate);
        }
    }

    public List<Service> findByDateBetween(LocalDate start, LocalDate end) {
        return this.servicePersistence.findByDateBetween(start, end);
    }

    public void editService(Long id, String plate, String type, String description) {
        Vehicle vehicle = this.vehicleController.findOneByPlate(plate);

        Service service = new Service(id, vehicle, type, description);

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
