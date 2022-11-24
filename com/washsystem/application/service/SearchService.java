package com.washsystem.application.service;

import com.washsystem.application.Action;
import com.washsystem.application.Prompt;
import com.washsystem.domain.controller.ServiceController;
import com.washsystem.domain.exception.EntityNotFoundException;
import com.washsystem.domain.model.Service;

import java.util.Scanner;

public class SearchService implements Action {

    private final ServiceController serviceController;

    public SearchService(ServiceController serviceController) {
        this.serviceController = serviceController;
    }

    @Override
    public void exec(Scanner scanner) {
        String plate = Prompt.forString(scanner, "Placa do Veiculo");
        String type = Prompt.forString(scanner, "Tipo de Servico");

        try {
            Service service = this.serviceController.findByPlateAndType(plate, type);

            System.out.println();
            System.out.println("ID: " + service.getId());
            System.out.println("ID do Veiculo: " + service.getVehicle().getId());
            System.out.println("Tipo do Servico: " + service.getType());
            System.out.println("Descricao: " + service.getDescription());
            System.out.println("Data: " + service.getDate());
            System.out.println();
        } catch (Exception e) {
            System.out.println("O servico nao foi encontrado: " + e.getMessage());
        }
    }
}