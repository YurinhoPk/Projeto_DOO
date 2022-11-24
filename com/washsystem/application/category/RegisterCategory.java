package com.washsystem.application.category;

import com.washsystem.application.Action;
import com.washsystem.application.Prompt;
import com.washsystem.domain.controller.CategoryController;

import java.util.Scanner;

public class RegisterCategory implements Action {

    private final CategoryController categoryController;

    public RegisterCategory(CategoryController categoryController) {
        this.categoryController = categoryController;
    }

    @Override
    public void exec(Scanner scanner) {
        String name = Prompt.forString(scanner, "Nome");
        Long price = Prompt.forLong(scanner, "Preco");
        Long meanTime = Prompt.forLong(scanner, "Tempo medio");

        try {
            this.categoryController.registerCategory(name, price, meanTime);
        } catch (Exception e) {
            System.out.println("Nao foi possivel registrar a categoria: " + e.getMessage());
        }
    }
}