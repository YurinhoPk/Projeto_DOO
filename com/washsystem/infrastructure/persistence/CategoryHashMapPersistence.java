package com.washsystem.infrastructure.persistence;

import com.washsystem.domain.model.Category;
import com.washsystem.domain.persistence.CategoryPersistence;
import com.washsystem.infrastructure.persistence.provider.LongIdProvider;

public class CategoryHashMapPersistence extends CommonHashMapPersistence<Long, Category, LongIdProvider> implements CategoryPersistence {

    public CategoryHashMapPersistence() {
        super(new LongIdProvider());
    }

    @Override
    public Category findOneByName(String name) {
        return this.findOneByValue(name, Category::getName);
    }

    @Override
    public Long countByPriceAndTimeId(Long id) {
        return this.countByValue(id, Category::getPriceAndTimeId);
    }
}
