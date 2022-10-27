package com.washsystem.domain.model;

import com.washsystem.domain.persistence.Identifiable;

public class Category implements Identifiable<Long> {

    private Long id;
    private String name;
    private Long priceAndTimeId;

    public Category(String name, Long priceAndTimeId) {
        this.name = name;
        this.priceAndTimeId = priceAndTimeId;
    }

    public Category(Long id, String name, Long priceAndTimeId) {
        this.id = id;
        this.name = name;
        this.priceAndTimeId = priceAndTimeId;
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

    public Long getPriceAndTimeId() {
        return priceAndTimeId;
    }

    public void setPriceAndTimeId(Long priceAndTimeId) {
        this.priceAndTimeId = priceAndTimeId;
    }
}