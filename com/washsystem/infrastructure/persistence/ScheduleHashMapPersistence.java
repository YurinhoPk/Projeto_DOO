package com.washsystem.infrastructure.persistence;

import com.washsystem.domain.model.Schedule;
import com.washsystem.domain.persistence.SchedulePersistence;
import com.washsystem.infrastructure.persistence.provider.LongIdProvider;

public class ScheduleHashMapPersistence extends CommonHashMapPersistence<Long, Schedule, LongIdProvider> implements SchedulePersistence {

    public ScheduleHashMapPersistence() {
        super(new LongIdProvider());
    }

    @Override
    public Long countByCategoryId(Long id) {
        return this.countByValue(id, Schedule::getCategoryId);
    }

    @Override
    public Long countByClientId(Long id) {
        return this.countByValue(id, Schedule::getClientId);
    }

    @Override
    public Long countByServiceId(Long id) {
        return this.countByValue(id, Schedule::getServiceId);
    }

    @Override
    public Long countByVehicleId(Long id) {
        return this.countByValue(id, Schedule::getVehicleId);
    }
}