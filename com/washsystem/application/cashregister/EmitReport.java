package com.washsystem.application.cashregister;

import com.washsystem.application.Action;
import com.washsystem.application.Prompt;
import com.washsystem.domain.controller.CashRegisterController;
import com.washsystem.domain.model.Report;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class EmitReport implements Action {

    private final CashRegisterController cashRegisterController;

    public EmitReport(CashRegisterController cashRegisterController) {
        this.cashRegisterController = cashRegisterController;
    }

    @Override
    public void exec(Scanner scanner) {
        LocalDate s;
        LocalDate e;

        while (true) {
            s = Prompt.forDate(scanner, "Data inicial");

            if (s == null) {
                System.out.println("Data invalida!");
            } else {
                break;
            }
        }

        while (true) {
            e = Prompt.forDate(scanner, "Data final");

            if (e == null) {
                System.out.println("Data invalida!");
            } else {
                break;
            }
        }

        Report report = this.cashRegisterController.generateIntervalReport(s, e);

        System.out.println(report.getStart());
        System.out.println(report.getEnd());

        System.out.println("Servicos do Dia:");
        System.out.println();

        for (var service : report.getServiceList()) {
            System.out.println("  ID: " + service.getId());
            System.out.println("  ID do Veiculo: " + service.getVehicle().getId());
            System.out.println("  Tipo do Servico: " + service.getType());
            System.out.println("  Descricao: " + service.getDescription());
            System.out.println("  Data: " + service.getDate());
            System.out.println();
        }

        boolean saveReport = Prompt.forBool(scanner, "Salvar Relatorio?");

        if (saveReport) {
            this.cashRegisterController.saveReport(report);
        }
    }
}