package com.washsystem.domain.persistence;

import com.washsystem.domain.model.Category;

public interface CategoryPersistence extends CommonPersistence<Long, Category> {

    Category findOneByName(String name);
    Long countByPriceAndTimeId(Long id);
}
