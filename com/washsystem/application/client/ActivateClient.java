package com.washsystem.application.client;

import com.washsystem.application.Action;
import com.washsystem.application.Prompt;
import com.washsystem.domain.controller.ClientController;

import java.util.Scanner;

public class ActivateClient implements Action {

    private final ClientController clientController;

    public ActivateClient(ClientController clientController) {
        this.clientController = clientController;
    }

    @Override
    public void exec(Scanner scanner) {
        Long id = Prompt.forLong(scanner, "ID");

        try {
            this.clientController.activateClient(id);
        } catch (Exception e) {
            System.out.println("Nao foi possivel ativar o cliente: " + e.getMessage());
        }
    }
}