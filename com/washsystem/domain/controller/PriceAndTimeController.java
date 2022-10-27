package com.washsystem.domain.controller;

import com.washsystem.domain.exception.EntityHasScheduledServicesException;
import com.washsystem.domain.exception.EntityNotFoundException;
import com.washsystem.domain.model.PriceAndTime;
import com.washsystem.domain.persistence.PriceAndTimePersistence;

import java.util.List;

public class PriceAndTimeController {

    private PriceAndTimePersistence priceAndTimePersistence;
    private CategoryController categoryController;

    public PriceAndTimeController() {
    }

    public PriceAndTimeController(PriceAndTimePersistence priceAndTimePersistence, CategoryController categoryController) {
        this.priceAndTimePersistence = priceAndTimePersistence;
        this.categoryController = categoryController;
    }

    public void registerPriceAndTime(Long price, Long time) {
        PriceAndTime priceAndTime = new PriceAndTime(price, time);
        this.priceAndTimePersistence.create(priceAndTime);
    }

    public PriceAndTime findOneByPriceAndTime(Long price, Long time) throws EntityNotFoundException {
        PriceAndTime priceAndTime = this.priceAndTimePersistence.findOneByPriceAndTime(price, time);

        if (priceAndTime != null) {
            return priceAndTime;
        } else {
            throw new EntityNotFoundException();
        }
    }

    public void editPriceAndTime(Long id, Long price, Long time) {
        PriceAndTime priceAndTime = new PriceAndTime(id, price, time);
        this.priceAndTimePersistence.save(priceAndTime);
    }

    public void deletePriceAndTime(Long id) throws EntityHasScheduledServicesException {
        if (!this.categoryController.verifyPriceAndTimeUsage(id)) {
            this.priceAndTimePersistence.delete(id);
        } else {
            throw new EntityHasScheduledServicesException();
        }
    }

    public void setPriceAndTimePersistence(PriceAndTimePersistence priceAndTimePersistence) {
        this.priceAndTimePersistence = priceAndTimePersistence;
    }

    public void setCategoryController(CategoryController categoryController) {
        this.categoryController = categoryController;
    }
}
