package com.washsystem.application.client;

import com.washsystem.application.Action;
import com.washsystem.domain.controller.ClientController;
import com.washsystem.domain.model.Client;

import java.util.List;
import java.util.Scanner;

public class SearchClient implements Action {

    private final ClientController clientController;

    public SearchClient(ClientController clientController) {
        this.clientController = clientController;
    }

    @Override
    public void exec(Scanner scanner) {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        List<Client> clients = clientController.findByCpf(cpf);

        System.out.println("");
        System.out.println("----- Clientes Encontrados -------------");
        System.out.println("");

        for (Client client : clients) {
            System.out.println("ID:       " + client.getId());
            System.out.println("CPF:      " + client.getCpf());
            System.out.println("Nome:     " + client.getName());
            System.out.println("Email:    " + client.getEmail());
            System.out.println("Telefone: " + client.getTelephone());
            System.out.println("Ativo:    " + client.isActive());
            System.out.println();
        }
    }
}