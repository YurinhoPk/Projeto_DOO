package com.washsystem.domain.controller;

import com.washsystem.domain.exception.EntityHasScheduledServicesException;
import com.washsystem.domain.exception.EntityNotFoundException;
import com.washsystem.domain.model.Client;
import com.washsystem.domain.persistence.ClientPersistence;

import java.util.List;

public class ClientController {

	private final ClientPersistence clientPersistence;
	private final ScheduleController scheduleController;

	public ClientController(ClientPersistence clientPersistence, ScheduleController scheduleController) {
		this.clientPersistence = clientPersistence;
		this.scheduleController = scheduleController;
	}

	public void registerClient(String cpf, String name, String email, String telephone) {
		Client client = new Client(cpf, name, email, telephone);
		this.clientPersistence.create(client);
	}

	public Client findOneByCpf(String cpf) {
		return this.clientPersistence.findOneByCpf(cpf);
	}

	public void activateClient(Long id) throws EntityNotFoundException {
		Client client = this.clientPersistence.findById(id);

		if (client != null) {
			client.setActive(true);
			this.clientPersistence.save(client);
		} else {
			throw new EntityNotFoundException();
		}
	}

	public void editClient(Long id, String cpf, String name, String email, String telephone) {
		Client client = new Client(id, cpf, name, email, telephone);
		this.clientPersistence.save(client);
	}

	public void deleteClient(Long id) throws EntityHasScheduledServicesException {
		if (!this.scheduleController.verifyClientSchedule(id)) {
			this.clientPersistence.delete(id);
		} else {
			throw new EntityHasScheduledServicesException();
		}
	}
}