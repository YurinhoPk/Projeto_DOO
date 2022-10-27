package com.washsystem.domain.model;

import com.washsystem.domain.persistence.Identifiable;

public class Vehicle implements Identifiable<Long> {

    private Long id;
    private String plate;
    private String model;
    private String brand;
    private Long categoryId;

    public Vehicle(String plate, String model, String brand, Long categoryId) {
        this.plate = plate;
        this.model = model;
        this.brand = brand;
        this.categoryId = categoryId;
    }

    public Vehicle(Long id, String plate, String model, String brand, Long categoryId) {
        this.id = id;
        this.plate = plate;
        this.model = model;
        this.brand = brand;
        this.categoryId = categoryId;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
