package com.washsystem.domain.controller;

import com.washsystem.domain.exception.EntityHasScheduledServicesException;
import com.washsystem.domain.exception.EntityNotFoundException;
import com.washsystem.domain.model.Category;
import com.washsystem.domain.model.PriceAndTime;
import com.washsystem.domain.persistence.CategoryPersistence;

import java.util.List;

public class CategoryController {

    private final CategoryPersistence categoryPersistence;
    private final PriceAndTimeController priceAndTimeController;
    private final ScheduleController scheduleController;

    public CategoryController(
        CategoryPersistence categoryPersistence,
        PriceAndTimeController priceAndTimeController,
        ScheduleController scheduleController
    ) {
        this.categoryPersistence = categoryPersistence;
        this.priceAndTimeController = priceAndTimeController;
        this.scheduleController = scheduleController;
    }

    public void registerCategory(String name, Long price, Long meanTime) {
        PriceAndTime priceAndTime = this.priceAndTimeController.findOneByPriceAndTime(price, meanTime);

        Category category = new Category(name, priceAndTime.getId());

        this.categoryPersistence.create(category);
    }

    public List<Category> findAll() {
        return this.categoryPersistence.findAll();
    }

    public Category findById(Long id) throws EntityNotFoundException {
        Category category = this.categoryPersistence.findById(id);

        if (category != null) {
            return category;
        } else {
            throw new EntityNotFoundException();
        }
    }

    public Category findOneByName(String name) throws EntityNotFoundException {
        Category category = this.categoryPersistence.findOneByName(name);

        if (category != null) {
            return category;
        } else {
            throw new EntityNotFoundException();
        }
    }

    public void editCategory(Long id, String name, Long price, Long meanTime) {
        PriceAndTime priceAndTime = this.priceAndTimeController.findOneByPriceAndTime(price, meanTime);

        Category category = new Category(id, name, priceAndTime.getId());

        this.categoryPersistence.save(category);
    }

    public boolean verifyPriceAndTimeUsage(Long id) {
        Long priceAndTimeCount = this.categoryPersistence.countByPriceAndTimeId(id);
        return priceAndTimeCount > 0L;
    }

    public void deleteCategory(Long id) throws EntityHasScheduledServicesException {
        if (!this.scheduleController.verifyCategorySchedule(id)) {
            this.categoryPersistence.delete(id);
        } else {
            throw new EntityHasScheduledServicesException();
        }
    }
}
