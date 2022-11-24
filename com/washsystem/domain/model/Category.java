package com.washsystem.domain.model;

import com.washsystem.domain.persistence.Identifiable;

public class Category implements Identifiable<Long> {

    private Long id;
    private String name;
    private PriceAndTime priceAndTime;

    public Category(String name, PriceAndTime priceAndTime) {
        this.name = name;
        this.priceAndTime = priceAndTime;
    }

    public Category(Long id, String name, PriceAndTime priceAndTime) {
        this.id = id;
        this.name = name;
        this.priceAndTime = priceAndTime;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PriceAndTime getPriceAndTime() {
        return priceAndTime;
    }

    public void setPriceAndTime(PriceAndTime priceAndTime) {
        this.priceAndTime = priceAndTime;
    }
}