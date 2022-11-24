package com.washsystem.infrastructure.persistence.repository;

import com.washsystem.infrastructure.persistence.entity.CategoryEntity;

public interface CategoryRepository extends CommonRepository<Long, CategoryEntity> {

    CategoryEntity findOneByName(String name);
    Long countByPriceAndTimeId(Long id);
}
