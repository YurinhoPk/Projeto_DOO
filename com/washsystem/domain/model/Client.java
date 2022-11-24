package com.washsystem.domain.model;

import com.washsystem.domain.persistence.Identifiable;

public class Client implements Identifiable<Long> {

	private Long id;
	private String cpf;
	private String name;
	private String email;
	private String telephone;
	private boolean active;

	public Client(String cpf, String name, String email, String telephone) {
		this.id = null;
		this.cpf = cpf;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.active = false;
	}

	public Client(Long id, String cpf, String name, String email, String telephone) {
		this.id = id;
		this.cpf = cpf;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.active = false;
	}

	public Client(Long id, String cpf, String name, String email, String telephone, boolean active) {
		this.id = id;
		this.cpf = cpf;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.active = active;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}