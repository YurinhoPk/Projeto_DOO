package com.washsystem.infrastructure.persistence.mapper;

import com.washsystem.domain.model.PriceAndTime;
import com.washsystem.infrastructure.persistence.entity.PriceAndTimeEntity;

public class PriceAndTimeMapper implements Mapper<Long, PriceAndTime, PriceAndTimeEntity> {

    @Override
    public PriceAndTime toModel(PriceAndTimeEntity priceAndTimeEntity) {
        return new PriceAndTime(
            priceAndTimeEntity.getId(),
            priceAndTimeEntity.getPrice(),
            priceAndTimeEntity.getTime()
        );
    }

    @Override
    public PriceAndTimeEntity toEntity(PriceAndTime priceAndTime) {
        return new PriceAndTimeEntity(
            priceAndTime.getId(),
            priceAndTime.getPrice(),
            priceAndTime.getTime()
        );
    }
}
