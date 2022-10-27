package com.washsystem.domain.persistence;

import com.washsystem.domain.model.Client;

import java.util.List;

public interface ClientPersistence extends CommonPersistence<Long, Client> {

    Client findOneByCpf(String cpf);
}