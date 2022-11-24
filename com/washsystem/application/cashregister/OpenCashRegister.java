package com.washsystem.application.cashregister;

import com.washsystem.application.Action;
import com.washsystem.domain.controller.CashRegisterController;

import java.util.Scanner;

public class OpenCashRegister implements Action {

    private final CashRegisterController cashRegisterController;

    public OpenCashRegister(CashRegisterController cashRegisterController) {
        this.cashRegisterController = cashRegisterController;
    }

    @Override
    public void exec(Scanner scanner) {
        try {
            this.cashRegisterController.open();
            System.out.println("Caixa Registradora aberta");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}