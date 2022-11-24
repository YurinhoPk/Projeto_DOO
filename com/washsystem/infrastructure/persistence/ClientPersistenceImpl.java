package com.washsystem.infrastructure.persistence;

import com.washsystem.domain.model.Client;
import com.washsystem.infrastructure.persistence.entity.ClientEntity;
import com.washsystem.infrastructure.persistence.mapper.ClientMapper;
import com.washsystem.infrastructure.persistence.repository.ClientRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ClientPersistenceImpl implements com.washsystem.domain.persistence.ClientPersistence {

	private final ClientRepository clientRepository;
	private final ClientMapper mapper;

	public ClientPersistenceImpl(ClientRepository clientRepository, ClientMapper mapper) {
		this.clientRepository = clientRepository;
		this.mapper = mapper;
	}

	@Override
	public Client create(Client client) {
		return this.toModel(this.clientRepository.create(this.toEntity(client)));
	}

	@Override
	public Client save(Client client) {
		return this.toModel(this.clientRepository.save(this.toEntity(client)));
	}

	@Override
	public List<Client> findAll() {
		return this.clientRepository.findAll()
			.stream()
			.map(this::toModel)
			.collect(Collectors.toList());
	}

	@Override
	public Client findById(Long id) {
		return this.toModel(this.clientRepository.findById(id));
	}

	@Override
	public void delete(Long id) {
		this.clientRepository.delete(id);
	}

	@Override
	public Client findOneByCpf(String cpf) {
		return this.toModel(this.clientRepository.findOneByCpf(cpf));
	}

	private ClientEntity toEntity(Client client) {
		return this.mapper.toEntity(client);
	}

	private Client toModel(ClientEntity client) {
		return this.mapper.toModel(client);
	}
}