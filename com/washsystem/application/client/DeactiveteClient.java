package com.washsystem.application.client;

import com.washsystem.application.Action;
import com.washsystem.application.Prompt;
import com.washsystem.domain.controller.ClientController;

import java.util.Scanner;

public class DeactiveteClient implements Action {

    private final ClientController clientController;

    public DeactiveteClient(ClientController clientController) {
        this.clientController = clientController;
    }

    @Override
    public void exec(Scanner scanner) {
        Long id = Prompt.forLong(scanner, "ID");

        try {
            this.clientController.deactivateClient(id);
        } catch (Exception e) {
            System.out.println("Nao foi possivel desativar o cliente: " + e.getMessage());
        }
    }
}