package com.washsystem.infrastructure.persistence.repository;

import com.washsystem.infrastructure.persistence.entity.PriceAndTimeEntity;

public interface PriceAndTimeRepository extends CommonRepository<Long, PriceAndTimeEntity> {

    PriceAndTimeEntity findOneByPriceAndTime(Long price, Long time);
}
