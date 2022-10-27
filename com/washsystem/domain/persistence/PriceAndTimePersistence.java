package com.washsystem.domain.persistence;

import com.washsystem.domain.model.PriceAndTime;

import java.util.List;

public interface PriceAndTimePersistence extends CommonPersistence<Long, PriceAndTime> {

    PriceAndTime findOneByPriceAndTime(Long price, Long time);
}
