package com.washsystem.infrastructure.persistence.repository.impl;

import com.washsystem.infrastructure.persistence.entity.ScheduleEntity;
import com.washsystem.infrastructure.persistence.provider.LongIdProvider;
import com.washsystem.infrastructure.persistence.repository.ScheduleRepository;

public class ScheduleHashMapRepository extends CommonHashMapRepository<Long, ScheduleEntity, LongIdProvider> implements ScheduleRepository {

    public ScheduleHashMapRepository() {
        super(new LongIdProvider());
    }

    @Override
    public Long countByCategoryId(Long id) {
        return this.countByValue(id, ScheduleEntity::getCategoryId);
    }

    @Override
    public Long countByClientId(Long id) {
        return this.countByValue(id, ScheduleEntity::getClientId);
    }

    @Override
    public Long countByServiceId(Long id) {
        return this.countByValue(id, ScheduleEntity::getServiceId);
    }

    @Override
    public Long countByVehicleId(Long id) {
        return this.countByValue(id, ScheduleEntity::getVehicleId);
    }
}