package com.washsystem.application.schedule;

import com.washsystem.application.Action;
import com.washsystem.application.Prompt;
import com.washsystem.domain.controller.ScheduleController;
import com.washsystem.domain.model.Status;

import java.util.Scanner;

public class EditSchedule implements Action {

    private final ScheduleController scheduleController;

    public EditSchedule(ScheduleController scheduleController) {
        this.scheduleController = scheduleController;
    }

    @Override
    public void exec(Scanner scanner) {
        Long id = Prompt.forLong(scanner, "ID");

        Status status;

        while (true) {
            try {
                String statusStr = Prompt.forString(scanner, "Status");
                status = Status.valueOf(statusStr);
                break;
            } catch (Exception e) {
                System.out.println("Status invalido");
            }
        }

        try {
            this.scheduleController.editSchedule(id, status);
        } catch (Exception e) {
            System.out.println("Nao foi possivel editar o agendamento: " + e.getMessage());
        }
    }
}