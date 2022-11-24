package com.washsystem.infrastructure.persistence.repository.impl;

import com.washsystem.infrastructure.persistence.entity.ServiceEntity;
import com.washsystem.infrastructure.persistence.provider.LongIdProvider;
import com.washsystem.infrastructure.persistence.repository.ServiceRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ServiceHashMapRepository extends CommonHashMapRepository<Long, ServiceEntity, LongIdProvider> implements ServiceRepository {

    public ServiceHashMapRepository() {
        super(new LongIdProvider());
    }

    @Override
    public ServiceEntity findByVehicleIdAndType(Long id, String type) {
        return this.filterOne((service) ->
            Objects.equals(service.getVehicleId(), id)
                && Objects.equals(service.getType(), type)
        );
    }

    @Override
    public List<ServiceEntity> findByDateBetween(LocalDate start, LocalDate end) {
        return this.filter((service) -> {
            LocalDate date = service.getDate().toLocalDate();

            return (
                start.isBefore(date)
                    || start.isEqual(date)
            ) && (
                date.isBefore(date)
                    || date.isEqual(date)
            );
        });
    }
}