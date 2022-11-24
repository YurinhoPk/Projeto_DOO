package com.washsystem.application.cashregister;

import com.washsystem.application.Action;
import com.washsystem.application.Prompt;
import com.washsystem.domain.controller.CashRegisterController;

import java.util.Scanner;

public class RegisterPayment implements Action {

    private final CashRegisterController cashRegisterController;

    public RegisterPayment(CashRegisterController cashRegisterController) {
        this.cashRegisterController = cashRegisterController;
    }

    @Override
    public void exec(Scanner scanner) {
        Long value = Prompt.forMonetaryValue(scanner, "Valor");

        cashRegisterController.registerPayment(value);
    }
}