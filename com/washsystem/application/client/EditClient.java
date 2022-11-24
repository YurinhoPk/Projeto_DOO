package com.washsystem.application.client;

import com.washsystem.application.Action;
import com.washsystem.application.Prompt;
import com.washsystem.domain.controller.ClientController;

import java.util.Scanner;

public class EditClient implements Action {

    private final ClientController clientController;

    public EditClient(ClientController clientController) {
        this.clientController = clientController;
    }

    @Override
    public void exec(Scanner scanner) {
        Long id = Prompt.forLong(scanner, "ID");
        String cpf = Prompt.forString(scanner, "CPF");
        String name = Prompt.forString(scanner, "Nome");
        String email = Prompt.forString(scanner, "Email");
        String telephone = Prompt.forString(scanner, "Telefone");

        try {
            this.clientController.editClient(id, cpf, name, email, telephone);
        } catch (Exception e) {
            System.out.println("Nao foi possivel editar o cliente: " + e.getMessage());
        }
    }
}