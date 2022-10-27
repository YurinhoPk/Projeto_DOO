package com.washsystem.domain.controller;

import com.washsystem.domain.model.Schedule;
import com.washsystem.domain.model.Status;
import com.washsystem.domain.persistence.SchedulePersistence;

import java.util.Date;

public class ScheduleController {

    private final SchedulePersistence schedulePersistence;

    public ScheduleController(SchedulePersistence schedulePersistence) {
        this.schedulePersistence = schedulePersistence;
    }

    public void registerSchedule(Long clientId, Long serviceId, Long vehicleId, Long categoryId, Date date) {
        Schedule schedule = new Schedule(clientId, serviceId, vehicleId, categoryId, date, Status.NEW);
        this.schedulePersistence.create(schedule);
    }

    public void editSchedule(Long id, Status status) {
        Schedule schedule = this.schedulePersistence.findById(id);
        schedule.setStatus(status);
        this.schedulePersistence.save(schedule);
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
