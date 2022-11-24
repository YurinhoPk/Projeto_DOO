package com.washsystem.infrastructure.persistence.repository.impl;

import com.washsystem.infrastructure.persistence.entity.PriceAndTimeEntity;
import com.washsystem.infrastructure.persistence.provider.LongIdProvider;
import com.washsystem.infrastructure.persistence.repository.PriceAndTimeRepository;

import java.util.Objects;

public class PriceAndTimeHashMapRepository extends CommonHashMapRepository<Long, PriceAndTimeEntity, LongIdProvider> implements PriceAndTimeRepository {

    public PriceAndTimeHashMapRepository() {
        super(new LongIdProvider());
    }

    @Override
    public PriceAndTimeEntity findOneByPriceAndTime(Long price, Long time) {
        return this.filterOne((priceAndTime) ->
            Objects.equals(priceAndTime.getPrice(), price)
                && Objects.equals(priceAndTime.getTime(), time)
        );
    }
}