package com.washsystem.infrastructure.persistence.provider;

import com.washsystem.domain.persistence.IdProvider;

public class LongIdProvider implements IdProvider<Long> {

    private Long nextId = 0L;

    public Long next() {
        Long nextId = this.nextId;
        this.nextId += 1;
        return nextId;
    }
}
