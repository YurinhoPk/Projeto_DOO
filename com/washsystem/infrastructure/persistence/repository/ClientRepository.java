package com.washsystem.infrastructure.persistence.repository;

import com.washsystem.infrastructure.persistence.entity.ClientEntity;

public interface ClientRepository extends CommonRepository<Long, ClientEntity> {

    ClientEntity findOneByCpf(String cpf);
}