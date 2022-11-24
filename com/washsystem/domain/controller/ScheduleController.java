package com.washsystem.domain.controller;

import com.washsystem.domain.exception.EntityNotFoundException;
import com.washsystem.domain.model.*;
import com.washsystem.domain.persistence.SchedulePersistence;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class ScheduleController {

    private final SchedulePersistence schedulePersistence;
    private ClientController clientController;
    private ServiceController serviceController;
    private VehicleController vehicleController;
    private CategoryController categoryController;

    public ScheduleController(SchedulePersistence schedulePersistence) {
        this.schedulePersistence = schedulePersistence;
    }

    public void setClientController(ClientController clientController) {
        this.clientController = clientController;
    }

    public void setServiceController(ServiceController serviceController) {
        this.serviceController = serviceController;
    }

    public void setVehicleController(VehicleController vehicleController) {
        this.vehicleController = vehicleController;
    }

    public void setCategoryController(CategoryController categoryController) {
        this.categoryController = categoryController;
    }

    public void registerSchedule(String clientCpf, String vehiclePlate, String serviceType, String serviceDescription, String categoryName, LocalDateTime date) {
        Client client = this.clientController.findOneByCpf(clientCpf);
        Service service = this.serviceController.registerService(vehiclePlate, serviceType, serviceDescription);
        Vehicle vehicle = this.vehicleController.findOneByPlate(vehiclePlate);
        Category category = this.categoryController.findOneByName(categoryName);

        Schedule schedule = new Schedule(client, service, vehicle, category, date, Status.NEW);
        this.schedulePersistence.create(schedule);
    }

    public void editSchedule(Long id, Status status) throws EntityNotFoundException {
        Schedule schedule = this.schedulePersistence.findById(id);

        if (schedule != null) {
            schedule.setStatus(status);
            this.schedulePersistence.save(schedule);
        } else {
            throw new EntityNotFoundException("Nao existe Agendamento com id " + id);
        }
    }

    boolean verifyCategorySchedule(Long id) {
        Long categoryAgendaCount = this.schedulePersistence.countByCategoryId(id);
        return categoryAgendaCount > 0L;
    }

    boolean verifyClientSchedule(Long id) {
        Long clientAgendaCount = this.schedulePersistence.countByClientId(id);
        return clientAgendaCount > 0L;
    }

    boolean verifyServiceSchedule(Long id) {
        Long serviceAgendaCount = this.schedulePersistence.countByServiceId(id);
        return serviceAgendaCount > 0L;
    }

    boolean verifyVehicleSchedule(Long id) {
        Long vehicleAgendaCount = this.schedulePersistence.countByVehicleId(id);
        return vehicleAgendaCount > 0L;
    }
}
