package com.washsystem.application.service;

import com.washsystem.application.Action;
import com.washsystem.application.Prompt;
import com.washsystem.domain.controller.ScheduleController;
import com.washsystem.domain.controller.ServiceController;
import com.washsystem.domain.exception.EntityHasScheduledServicesException;

import java.util.Scanner;

public class DeleteService implements Action {

    private final ServiceController serviceController;

    public DeleteService(ServiceController serviceController) {
        this.serviceController = serviceController;
    }

    @Override
    public void exec(Scanner scanner) {
        Long id = Prompt.forLong(scanner, "ID");

        try {
            this.serviceController.deleteService(id);
        } catch (Exception e) {
            System.out.println("Nao foi possivel deletar o servico: " + e.getMessage());
        }
    }
}