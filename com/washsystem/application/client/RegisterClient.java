package com.washsystem.application.client;

import com.washsystem.application.Action;
import com.washsystem.domain.controller.ClientController;

import java.util.Scanner;

public class RegisterClient implements Action {

    private final ClientController clientController;

    public RegisterClient(ClientController clientController) {
        this.clientController = clientController;
    }

    @Override
    public void exec(Scanner scanner) {
        System.out.print("CPF:      ");
        String cpf = scanner.nextLine();

        System.out.print("Nome:     ");
        String name = scanner.nextLine();

        System.out.print("Email:    ");
        String email = scanner.nextLine();

        System.out.print("Telefone: ");
        String telephone = scanner.nextLine();

        clientController.registerClient(cpf, name, email, telephone);
    }
}