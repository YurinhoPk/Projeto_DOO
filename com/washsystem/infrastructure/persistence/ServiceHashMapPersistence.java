package com.washsystem.infrastructure.persistence;

import com.washsystem.domain.model.Service;
import com.washsystem.domain.persistence.ServicePersistence;
import com.washsystem.infrastructure.persistence.provider.LongIdProvider;

public class ServiceHashMapPersistence extends CommonHashMapPersistence<Long, Service, LongIdProvider> implements ServicePersistence {

    public ServiceHashMapPersistence() {
        super(new LongIdProvider());
    }
}