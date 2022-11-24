package com.washsystem.infrastructure.persistence.mapper;

import com.washsystem.domain.model.Schedule;
import com.washsystem.infrastructure.persistence.entity.ScheduleEntity;

public class ScheduleMapper implements Mapper<Long, Schedule, ScheduleEntity> {

    @Override
    public Schedule toModel(ScheduleEntity scheduleEntity) {
        return new Schedule(
            scheduleEntity.getId(),
            null,
            null,
            null,
            null,
            scheduleEntity.getDate(),
            scheduleEntity.getStatus()
        );
    }

    @Override
    public ScheduleEntity toEntity(Schedule schedule) {
        return new ScheduleEntity(
            schedule.getId(),
            null,
            null,
            null,
            null,
            schedule.getDate(),
            schedule.getStatus()
        );
    }
}
