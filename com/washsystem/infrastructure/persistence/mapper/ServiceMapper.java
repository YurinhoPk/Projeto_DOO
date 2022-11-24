package com.washsystem.infrastructure.persistence.mapper;

import com.washsystem.domain.model.Service;
import com.washsystem.infrastructure.persistence.entity.ServiceEntity;

public class ServiceMapper implements Mapper<Long, Service, ServiceEntity> {

    @Override
    public Service toModel(ServiceEntity serviceEntity) {
        return new Service(
            serviceEntity.getId(),
            null,
            serviceEntity.getType(),
            serviceEntity.getDescription(),
            serviceEntity.getDate()
        );
    }

    @Override
    public ServiceEntity toEntity(Service service) {
        return new ServiceEntity(
            service.getId(),
            null,
            service.getType(),
            service.getDescription(),
            service.getDate()
        );
    }
}
