package com.washsystem.application.schedule;

import com.washsystem.application.Action;
import com.washsystem.application.Prompt;
import com.washsystem.domain.controller.ScheduleController;
import com.washsystem.domain.model.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class RegisterSchedule implements Action {

    private final ScheduleController scheduleController;

    public RegisterSchedule(ScheduleController scheduleController) {
        this.scheduleController = scheduleController;
    }

    @Override
    public void exec(Scanner scanner) {
        String clientCpf = Prompt.forString(scanner, "CPF Cliente");
        String vehiclePlate = Prompt.forString(scanner, "Placa do Veiculo");
        String serviceType = Prompt.forString(scanner, "Tipo de Servico");
        String serviceDescription = Prompt.forString(scanner, "Descricao do Servico");
        String categoryName = Prompt.forString(scanner, "Categoria");
        LocalDateTime date = Prompt.forDateTime(scanner, "Data e Hora");

        try {
            this.scheduleController.registerSchedule(clientCpf, vehiclePlate, serviceType, serviceDescription, categoryName, date);
        } catch (Exception e) {
            System.out.println("Nao foi possivel fazer o agendamento: " + e.getMessage());
        }
    }
}