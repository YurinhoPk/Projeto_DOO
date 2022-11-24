package com.washsystem.application.client;

import com.washsystem.application.Action;
import com.washsystem.application.Prompt;
import com.washsystem.domain.controller.ClientController;

import java.util.Scanner;

public class DeleteClient implements Action {

    private final ClientController clientController;

    public DeleteClient(ClientController clientController) {
        this.clientController = clientController;
    }

    @Override
    public void exec(Scanner scanner) {
        Long id = Prompt.forLong(scanner, "ID");

        try {
            this.clientController.deleteClient(id);
        } catch (Exception e) {
            System.out.println("Nao foi possivel deletar o cliente: " + e.getMessage());
        }
    }
}