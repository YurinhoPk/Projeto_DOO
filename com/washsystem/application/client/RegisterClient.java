package com.washsystem.application.client;

import com.washsystem.application.Action;
import com.washsystem.application.Prompt;
import com.washsystem.domain.controller.ClientController;

import java.util.Scanner;

public class RegisterClient implements Action {

    private final ClientController clientController;

    public RegisterClient(ClientController clientController) {
        this.clientController = clientController;
    }

    @Override
    public void exec(Scanner scanner) {
        String cpf = Prompt.forString(scanner, "CPF");
        String name = Prompt.forString(scanner, "Nome");
        String email = Prompt.forString(scanner, "Email");
        String telephone = Prompt.forString(scanner, "Telefone");

        try {
            this.clientController.registerClient(cpf, name, email, telephone);
        } catch (Exception e) {
            System.out.println("Nao foi possivel registrar o cliente: " + e.getMessage());
        }
    }
}