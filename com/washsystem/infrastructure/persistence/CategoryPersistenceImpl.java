package com.washsystem.infrastructure.persistence;

import com.washsystem.domain.model.Category;
import com.washsystem.domain.model.PriceAndTime;
import com.washsystem.infrastructure.persistence.entity.CategoryEntity;
import com.washsystem.infrastructure.persistence.mapper.CategoryMapper;
import com.washsystem.infrastructure.persistence.repository.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryPersistenceImpl implements com.washsystem.domain.persistence.CategoryPersistence {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper mapper;
    private PriceAndTimePersistenceImpl priceAndTimePersistenceImpl;

    public CategoryPersistenceImpl(
        CategoryRepository categoryRepository,
        CategoryMapper mapper
    ) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    public void setPriceAndTimePersistenceImpl(PriceAndTimePersistenceImpl priceAndTimePersistenceImpl) {
        this.priceAndTimePersistenceImpl = priceAndTimePersistenceImpl;
    }

    @Override
    public Category create(Category category) {
        return this.toModel(this.categoryRepository.create(this.toEntity(category)));
    }

    @Override
    public Category save(Category category) {
        return this.toModel(this.categoryRepository.save(this.toEntity(category)));
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll()
            .stream()
            .map(this::toModel)
            .collect(Collectors.toList());
    }

    @Override
    public Category findById(Long id) {
        return this.toModel(this.categoryRepository.findById(id));
    }

    @Override
    public void delete(Long id) {
        this.categoryRepository.delete(id);
    }

    @Override
    public Category findOneByName(String name) {
        return this.toModel(this.categoryRepository.findOneByName(name));
    }

    @Override
    public Long countByPriceAndTimeId(Long id) {
        return this.categoryRepository.countByPriceAndTimeId(id);
    }

    protected CategoryEntity toEntity(Category category) {
        PriceAndTime priceAndTime = category.getPriceAndTime();
        if (priceAndTime.getId() == null) {
            priceAndTime = this.priceAndTimePersistenceImpl.create(priceAndTime);
        } else {
            priceAndTime = this.priceAndTimePersistenceImpl.save(priceAndTime);
        }

        CategoryEntity categoryEntity = this.mapper.toEntity(category);
        categoryEntity.setPriceAndTimeId(priceAndTime.getId());

        return categoryEntity;
    }

    protected Category toModel(CategoryEntity categoryEntity) {
        PriceAndTime priceAndTime = this.priceAndTimePersistenceImpl.findById(categoryEntity.getPriceAndTimeId());

        Category category = this.mapper.toModel(categoryEntity);
        category.setPriceAndTime(priceAndTime);

        return category;
    }

    protected CategoryRepository getRepository() {
        return this.categoryRepository;
    }
}
