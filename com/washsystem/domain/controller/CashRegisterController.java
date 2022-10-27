package com.washsystem.domain.controller;

import com.washsystem.domain.model.CashRegister;

import java.util.Date;

public class CashRegisterController {

    private final CashRegister cashRegister;

    public CashRegisterController() {
        this.cashRegister = new CashRegister();
    }

    public void open() {
        // ?
    }

    public void close() {
        // ?
    }

    public void generateReport() {
        // ?
    }

    public void generateIntervalReport(Date start, Date end) {
        // ?
    }

    public void saveReport() {
        // ?
    }

    private void sumTotalValue() {
        // ?
    }
}
