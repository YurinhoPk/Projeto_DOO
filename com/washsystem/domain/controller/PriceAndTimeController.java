package com.washsystem.domain.controller;

import com.washsystem.domain.exception.EntityHasScheduledServicesException;
import com.washsystem.domain.exception.EntityNotFoundException;
import com.washsystem.domain.model.Category;
import com.washsystem.domain.model.PriceAndTime;
import com.washsystem.domain.persistence.PriceAndTimePersistence;

import java.util.List;

public class PriceAndTimeController {

    private final PriceAndTimePersistence priceAndTimePersistence;
    private CategoryController categoryController;

    public PriceAndTimeController(PriceAndTimePersistence priceAndTimePersistence) {
        this.priceAndTimePersistence = priceAndTimePersistence;
    }

    public void setCategoryController(CategoryController categoryController) {
        this.categoryController = categoryController;
    }

    public void registerPriceAndTime(Long price, Long time) {
        PriceAndTime priceAndTime = new PriceAndTime(price, time);
        this.priceAndTimePersistence.create(priceAndTime);
    }

    public List<PriceAndTime> findAll() {
        return this.priceAndTimePersistence.findAll();
    }

    public PriceAndTime findOneByPriceAndTime(Long price, Long time) throws EntityNotFoundException {
        PriceAndTime priceAndTime = this.priceAndTimePersistence.findOneByPriceAndTime(price, time);

        if (priceAndTime != null) {
            return priceAndTime;
        } else {
            throw new EntityNotFoundException("Nao existe Preco e Tempo com esses valores");
        }
    }

    public void editPriceAndTime(Long id, Long price, Long time) throws EntityNotFoundException {
        PriceAndTime priceAndTime = new PriceAndTime(id, price, time);

        if (this.priceAndTimePersistence.findById(id) != null) {
            this.priceAndTimePersistence.save(priceAndTime);
        } else {
            throw new EntityNotFoundException("Nao existe Preco e Tempo com id " + id);
        }
    }

    public void deletePriceAndTime(Long id) throws EntityHasScheduledServicesException {
        if (!this.categoryController.verifyPriceAndTimeUsage(id)) {
            this.priceAndTimePersistence.delete(id);
        } else {
            throw new EntityHasScheduledServicesException();
        }
    }
}
