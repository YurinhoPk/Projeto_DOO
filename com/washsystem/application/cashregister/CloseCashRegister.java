package com.washsystem.application.cashregister;

import com.washsystem.application.Action;
import com.washsystem.application.Prompt;
import com.washsystem.domain.controller.CashRegisterController;

import java.util.Scanner;

public class CloseCashRegister implements Action {

    private final CashRegisterController cashRegisterController;

    public CloseCashRegister(CashRegisterController cashRegisterController) {
        this.cashRegisterController = cashRegisterController;
    }

    @Override
    public void exec(Scanner scanner) {
        while (true) {
            Long current;

            try {
                current = this.cashRegisterController.sumTotalValue();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }

            System.out.println("Total do Dia: " + Prompt.asMonetary(current));

            boolean add = Prompt.forBool(scanner, "Adicionar mais valores?");

            if (add) {
                Long value = Prompt.forMonetaryValue(scanner, "Valor");
                System.out.println("Adicionando valor: " + Prompt.asMonetary(value));
                this.cashRegisterController.registerPayment(value);
            } else {
                System.out.println("Fechando o Caixa");
                this.cashRegisterController.close();
                return;
            }
        }
    }
}
