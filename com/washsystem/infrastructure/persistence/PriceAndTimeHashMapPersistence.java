package com.washsystem.infrastructure.persistence;

import com.washsystem.domain.model.PriceAndTime;
import com.washsystem.domain.persistence.PriceAndTimePersistence;
import com.washsystem.infrastructure.persistence.provider.LongIdProvider;

import java.util.List;
import java.util.Objects;

public class PriceAndTimeHashMapPersistence extends CommonHashMapPersistence<Long, PriceAndTime, LongIdProvider> implements PriceAndTimePersistence {

    public PriceAndTimeHashMapPersistence() {
        super(new LongIdProvider());
    }

    @Override
    public PriceAndTime findOneByPriceAndTime(Long price, Long time) {
        return this.filterOne((priceAndTime) ->
            Objects.equals(priceAndTime.getPrice(), price)
                && Objects.equals(priceAndTime.getTime(), time)
        );
    }
}