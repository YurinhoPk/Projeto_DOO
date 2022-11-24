package com.washsystem.infrastructure.persistence;

import com.washsystem.domain.model.PriceAndTime;
import com.washsystem.infrastructure.persistence.entity.PriceAndTimeEntity;
import com.washsystem.infrastructure.persistence.mapper.PriceAndTimeMapper;
import com.washsystem.infrastructure.persistence.repository.PriceAndTimeRepository;

import java.util.List;
import java.util.stream.Collectors;

public class PriceAndTimePersistenceImpl implements com.washsystem.domain.persistence.PriceAndTimePersistence {

    private final PriceAndTimeRepository priceAndTimeRepository;
    private final PriceAndTimeMapper mapper;

    public PriceAndTimePersistenceImpl(PriceAndTimeRepository priceAndTimeRepository, PriceAndTimeMapper mapper) {
        this.priceAndTimeRepository = priceAndTimeRepository;
        this.mapper = mapper;
    }

    @Override
    public PriceAndTime create(PriceAndTime priceAndTime) {
        return this.toModel(this.priceAndTimeRepository.create(this.toEntity(priceAndTime)));
    }

    @Override
    public PriceAndTime save(PriceAndTime priceAndTime) {
        return this.toModel(this.priceAndTimeRepository.save(this.toEntity(priceAndTime)));
    }

    @Override
    public List<PriceAndTime> findAll() {
        return this.priceAndTimeRepository.findAll()
            .stream()
            .map(this::toModel)
            .collect(Collectors.toList());
    }

    @Override
    public PriceAndTime findById(Long id) {
        return this.toModel(this.priceAndTimeRepository.findById(id));
    }

    @Override
    public void delete(Long id) {
        this.priceAndTimeRepository.delete(id);
    }

    @Override
    public PriceAndTime findOneByPriceAndTime(Long price, Long time) {
        return this.toModel(this.priceAndTimeRepository.findOneByPriceAndTime(price, time));
    }

    private PriceAndTimeEntity toEntity(PriceAndTime priceAndTime) {
        return this.mapper.toEntity(priceAndTime);
    }

    private PriceAndTime toModel(PriceAndTimeEntity priceAndTimeEntity) {
        return this.mapper.toModel(priceAndTimeEntity);
    }
}