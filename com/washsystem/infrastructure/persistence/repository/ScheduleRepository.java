package com.washsystem.infrastructure.persistence.repository;

import com.washsystem.domain.model.Schedule;
import com.washsystem.infrastructure.persistence.entity.ScheduleEntity;

public interface ScheduleRepository extends CommonRepository<Long, ScheduleEntity> {

    Long countByCategoryId(Long id);
    Long countByClientId(Long id);
    Long countByServiceId(Long id);
    Long countByVehicleId(Long id);
}
