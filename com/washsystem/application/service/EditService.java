package com.washsystem.application.service;

import com.washsystem.application.Action;
import com.washsystem.application.Prompt;
import com.washsystem.domain.controller.ServiceController;
import com.washsystem.domain.exception.EntityNotFoundException;

import java.util.Scanner;

public class EditService implements Action {

    private final ServiceController serviceController;

    public EditService(ServiceController serviceController) {
        this.serviceController = serviceController;
    }

    @Override
    public void exec(Scanner scanner) {
        Long id = Prompt.forLong(scanner, "ID");
        String plate = Prompt.forString(scanner, "Placa do Veiculo");
        String type = Prompt.forString(scanner, "Tipo de Servico");
        String description = Prompt.forString(scanner, "Descricao do Servico");

        try {
            this.serviceController.editService(id, plate, type, description);
        } catch (Exception e) {
            System.out.println("Nao foi possivel editar o servico: " + e.getMessage());
        }
    }
}