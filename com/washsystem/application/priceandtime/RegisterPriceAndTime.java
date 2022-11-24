package com.washsystem.application.priceandtime;

import com.washsystem.application.Action;
import com.washsystem.application.Prompt;
import com.washsystem.domain.controller.PriceAndTimeController;

import java.util.Scanner;

public class RegisterPriceAndTime implements Action {

    private final PriceAndTimeController priceAndTimeController;

    public RegisterPriceAndTime(PriceAndTimeController priceAndTimeController) {
        this.priceAndTimeController = priceAndTimeController;
    }

    @Override
    public void exec(Scanner scanner) {
        Long price = Prompt.forLong(scanner, "Preco");
        Long time = Prompt.forLong(scanner, "Tempo");

        try {
            this.priceAndTimeController.registerPriceAndTime(price, time);
        } catch (Exception e) {
            System.out.println("Nao foi possivel registrar o preco e tempo: " + e.getMessage());
        }
    }
}