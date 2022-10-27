package com.washsystem.domain.model;

import com.washsystem.domain.persistence.Identifiable;

public class Service implements Identifiable<Long> {

    private Long id;
    private Long vehicleId;
    private String type;
    private String description;

    public Service(Long vehicleId, String type, String description) {
        this.vehicleId = vehicleId;
        this.type = type;
        this.description = description;
    }

    public Service(Long id, Long vehicleId, String type, String description) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.type = type;
        this.description = description;
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
}