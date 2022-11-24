package com.washsystem.domain.model;

import com.washsystem.domain.persistence.Identifiable;

import java.time.LocalDateTime;
import java.util.Date;

public class Schedule implements Identifiable<Long> {

    private Long id;
    private Client client;
    private Service service;
    private Vehicle vehicle;
    private Category category;
    private LocalDateTime date;
    private Status status;

    public Schedule(Client client, Service service, Vehicle vehicle, Category category, LocalDateTime date, Status status) {
        this.client = client;
        this.service = service;
        this.vehicle = vehicle;
        this.category = category;
        this.date = date;
        this.status = status;
    }

    public Schedule(Long id, Client client, Service service, Vehicle vehicle, Category category, LocalDateTime date, Status status) {
        this.id = id;
        this.client = client;
        this.service = service;
        this.vehicle = vehicle;
        this.category = category;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
