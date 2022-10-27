package com.washsystem.domain.model;

import com.washsystem.domain.persistence.Identifiable;

import java.util.Date;

public class Schedule implements Identifiable<Long> {

    private Long id;
    private Long clientId;
    private Long serviceId;
    private Long vehicleId;
    private Long categoryId;
    private Date date;
    private Status status;

    public Schedule(Long clientId, Long serviceId, Long vehicleId, Long categoryId, Date date, Status status) {
        this.clientId = clientId;
        this.serviceId = serviceId;
        this.vehicleId = vehicleId;
        this.categoryId = categoryId;
        this.date = date;
        this.status = status;
    }

    public Schedule(Long id, Long clientId, Long serviceId, Long vehicleId, Long categoryId, Date date, Status status) {
        this.id = id;
        this.clientId = clientId;
        this.serviceId = serviceId;
        this.vehicleId = vehicleId;
        this.categoryId = categoryId;
        this.date = date;
        this.status = status;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
