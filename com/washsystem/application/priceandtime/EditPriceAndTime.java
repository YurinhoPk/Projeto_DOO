package com.washsystem.application.priceandtime;

import com.washsystem.application.Action;
import com.washsystem.application.Prompt;
import com.washsystem.domain.controller.PriceAndTimeController;

import java.util.Scanner;

public class EditPriceAndTime implements Action {

    private final PriceAndTimeController priceAndTimeController;

    public EditPriceAndTime(PriceAndTimeController priceAndTimeController) {
        this.priceAndTimeController = priceAndTimeController;
    }

    @Override
    public void exec(Scanner scanner) {
        Long id = Prompt.forLong(scanner, "ID");
        Long price = Prompt.forLong(scanner, "Preco");
        Long time = Prompt.forLong(scanner, "Tempo");

        try {
            this.priceAndTimeController.editPriceAndTime(id, price, time);
        } catch (Exception e) {
            System.out.println("Nao foi possivel editar o preco e tempo: " + e.getMessage());
        }
    }
}