package com.washsystem.infrastructure.persistence.repository;

import com.washsystem.infrastructure.persistence.entity.ServiceEntity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ServiceRepository extends CommonRepository<Long, ServiceEntity> {
    ServiceEntity findByVehicleIdAndType(Long id, String type);
    List<ServiceEntity> findByDateBetween(LocalDate start, LocalDate end);
}
