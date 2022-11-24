package com.washsystem.infrastructure.persistence.repository.impl;

import com.washsystem.infrastructure.persistence.entity.ClientEntity;
import com.washsystem.infrastructure.persistence.provider.LongIdProvider;
import com.washsystem.infrastructure.persistence.repository.ClientRepository;

public class ClientHashMapRepository extends CommonHashMapRepository<Long, ClientEntity, LongIdProvider> implements ClientRepository {

	public ClientHashMapRepository() {
		super(new LongIdProvider());
	}

	@Override
	public ClientEntity findOneByCpf(String cpf) {
		return this.findOneByValue(cpf, ClientEntity::getCpf);
	}
}