package com.washsystem.domain.persistence;

import com.washsystem.domain.model.Schedule;

public interface SchedulePersistence extends CommonPersistence<Long, Schedule> {

    Long countByCategoryId(Long id);
    Long countByClientId(Long id);
    Long countByServiceId(Long id);
    Long countByVehicleId(Long id);
}
