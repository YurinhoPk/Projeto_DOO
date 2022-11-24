package com.washsystem.application.priceandtime;

import com.washsystem.application.Action;
import com.washsystem.application.Prompt;
import com.washsystem.domain.controller.PriceAndTimeController;

import java.util.Scanner;

public class DeletePriceAndTime implements Action {

    private final PriceAndTimeController priceAndTimeController;

    public DeletePriceAndTime(PriceAndTimeController priceAndTimeController) {
        this.priceAndTimeController = priceAndTimeController;
    }

    @Override
    public void exec(Scanner scanner) {
        Long id = Prompt.forLong(scanner, "ID");

        try {
            this.priceAndTimeController.deletePriceAndTime(id);
        } catch (Exception e) {
            System.out.println("Nao foi possivel deletar o preco e tempo: " + e.getMessage());
        }
    }
}