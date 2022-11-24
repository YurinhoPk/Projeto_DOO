package com.washsystem.domain.persistence;

import com.washsystem.domain.model.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ServicePersistence extends CommonPersistence<Long, Service> {
    Service findByVehicleIdAndType(Long id, String type);
    List<Service> findByDateBetween(LocalDate start, LocalDate end);
}
