package com.washsystem.infrastructure.persistence.mapper;

import com.washsystem.domain.model.Client;
import com.washsystem.infrastructure.persistence.entity.ClientEntity;

public class ClientMapper implements Mapper<Long, Client, ClientEntity> {

    @Override
    public Client toModel(ClientEntity clientEntity) {
        return new Client(
            clientEntity.getId(),
            clientEntity.getCpf(),
            clientEntity.getName(),
            clientEntity.getEmail(),
            clientEntity.getTelephone(),
            clientEntity.isActive()
        );
    }

    @Override
    public ClientEntity toEntity(Client client) {
        return new ClientEntity(
            client.getId(),
            client.getCpf(),
            client.getName(),
            client.getEmail(),
            client.getTelephone(),
            client.isActive()
        );
    }
}
