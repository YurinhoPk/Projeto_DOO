package com.washsystem.infrastructure.persistence;

import com.washsystem.domain.model.Client;
import com.washsystem.domain.persistence.ClientPersistence;
import com.washsystem.infrastructure.persistence.provider.LongIdProvider;

import java.util.List;

public class ClientHashMapPersistence extends CommonHashMapPersistence<Long, Client, LongIdProvider> implements ClientPersistence {

	public ClientHashMapPersistence() {
		super(new LongIdProvider());
	}

	@Override
	public Client findOneByCpf(String cpf) {
		return this.findOneByValue(cpf, Client::getCpf);
	}
}