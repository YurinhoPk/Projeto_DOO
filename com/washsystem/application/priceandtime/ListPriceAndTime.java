package com.washsystem.application.priceandtime;

import com.washsystem.application.Action;
import com.washsystem.domain.controller.PriceAndTimeController;
import com.washsystem.domain.model.PriceAndTime;

import java.util.List;
import java.util.Scanner;

public class ListPriceAndTime implements Action {

    private final PriceAndTimeController priceAndTimeController;

    public ListPriceAndTime(PriceAndTimeController priceAndTimeController) {
        this.priceAndTimeController = priceAndTimeController;
    }

    @Override
    public void exec(Scanner scanner) {
        List<PriceAndTime> priceAndTimeList = this.priceAndTimeController.findAll();

        for (var priceAndTime : priceAndTimeList) {
            System.out.println();
            System.out.println("ID: " + priceAndTime.getId());
            System.out.println("Preco: " + priceAndTime.getPrice());
            System.out.println("Tempo: " + priceAndTime.getTime());
            System.out.println();
        }
    }
}