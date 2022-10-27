package com.washsystem.domain.model;

import com.washsystem.domain.persistence.Identifiable;

public class PriceAndTime implements Identifiable<Long> {

    private Long id;
    private Long price;
    private Long time;

    public PriceAndTime(Long price, Long time) {
        this.price = price;
        this.time = time;
    }

    public PriceAndTime(Long id, Long price, Long time) {
        this.id = id;
        this.price = price;
        this.time = time;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}