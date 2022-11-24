package com.washsystem.domain.controller;

import com.washsystem.domain.model.Report;
import com.washsystem.domain.model.Service;
import com.washsystem.domain.persistence.ReportPersistence;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CashRegisterController {

    private final ReportPersistence reportPersistence;
    private ServiceController serviceController;

    private boolean isOpen;
    private List<Long> dailyIncomeList;

    public CashRegisterController(ReportPersistence reportPersistence) {
        this.isOpen = false;
        this.reportPersistence = reportPersistence;
    }

    public void setServiceController(ServiceController serviceController) {
        this.serviceController = serviceController;
    }

    public void open() {
        if (!this.isOpen) {
            this.dailyIncomeList = new ArrayList<>();
            this.isOpen = true;
        } else {
            throw new RuntimeException("O caixa ja esta aberto");
        }
    }

    public void close() {
        if (this.isOpen) {
            this.isOpen = false;
        } else {
            throw new RuntimeException("O caixa ja esta fechado");
        }
    }

    public Report generateReport() {
        LocalDate s = LocalDate.now();

        LocalDate e = LocalDate.now().plusDays(1L);

        return this.generateIntervalReport(s, e);
    }

    public Report generateIntervalReport(LocalDate start, LocalDate end) {
        List<Service> serviceList = this.serviceController.findByDateBetween(start, end);

        return new Report(start, end, serviceList);
    }

    public void saveReport(Report report) {
        this.reportPersistence.save(report);
    }

    public void registerPayment(Long value) {
        this.dailyIncomeList.add(value);
    }

    public Long sumTotalValue() {
        return this.dailyIncomeList
            .stream()
            .reduce(Long::sum)
            .orElse(0L);
    }
}
