package com.washsystem.infrastructure.persistence.repository.impl;

import com.washsystem.infrastructure.persistence.entity.ReportEntity;
import com.washsystem.infrastructure.persistence.provider.LongIdProvider;
import com.washsystem.infrastructure.persistence.repository.ReportRepository;

public class ReportHashMapRepository extends CommonHashMapRepository<Long, ReportEntity, LongIdProvider> implements ReportRepository {

    public ReportHashMapRepository() {
        super(new LongIdProvider());
    }
}
