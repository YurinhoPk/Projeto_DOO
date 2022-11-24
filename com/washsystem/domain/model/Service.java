package com.washsystem.domain.model;

import com.washsystem.domain.persistence.Identifiable;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Service implements Identifiable<Long> {

    private Long id;
    private Vehicle vehicle;
    private String type;
    private String description;
    private LocalDateTime date;

    public Service(Vehicle vehicle, String type, String description) {
        this.vehicle = vehicle;
        this.type = type;
        this.description = description;
        this.date = LocalDateTime.now();
    }

    public Service(Long id, Vehicle vehicle, String type, String description) {
        this.id = id;
        this.vehicle = vehicle;
        this.type = type;
        this.description = description;
        this.date = LocalDateTime.now();
    }

    public Service(Long id, Vehicle vehicle, String type, String description, LocalDateTime date) {
        this.id = id;
        this.vehicle = vehicle;
        this.type = type;
        this.description = description;
        this.date = date;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}