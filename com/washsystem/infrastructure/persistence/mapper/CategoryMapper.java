package com.washsystem.infrastructure.persistence.mapper;

import com.washsystem.domain.model.Category;
import com.washsystem.infrastructure.persistence.entity.CategoryEntity;

public class CategoryMapper implements Mapper<Long, Category, CategoryEntity> {

    @Override
    public Category toModel(CategoryEntity categoryEntity) {
        return new Category(
            categoryEntity.getId(),
            categoryEntity.getName(),
            null
        );
    }

    @Override
    public CategoryEntity toEntity(Category category) {
        return new CategoryEntity(
            category.getId(),
            category.getName(),
            null
        );
    }
}
