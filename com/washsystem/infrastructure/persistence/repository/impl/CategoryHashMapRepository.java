package com.washsystem.infrastructure.persistence.repository.impl;

import com.washsystem.infrastructure.persistence.entity.CategoryEntity;
import com.washsystem.infrastructure.persistence.provider.LongIdProvider;
import com.washsystem.infrastructure.persistence.repository.CategoryRepository;

public class CategoryHashMapRepository extends CommonHashMapRepository<Long, CategoryEntity, LongIdProvider> implements CategoryRepository {

    public CategoryHashMapRepository() {
        super(new LongIdProvider());
    }

    @Override
    public CategoryEntity findOneByName(String name) {
        return this.findOneByValue(name, CategoryEntity::getName);
    }

    @Override
    public Long countByPriceAndTimeId(Long id) {
        return this.countByValue(id, CategoryEntity::getPriceAndTimeId);
    }
}
