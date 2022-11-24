package com.washsystem.infrastructure.persistence.entity;

import com.washsystem.domain.persistence.Identifiable;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

public class ServiceEntity implements Identifiable<Long> {

    private Long id;
    private Long vehicleId;
    private String type;
    private String description;
    private LocalDateTime date;

    public ServiceEntity(Long id, Long vehicleId, String type, String description, LocalDateTime date) {
        this.id = id;
        this.vehicleId = vehicleId;
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

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
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