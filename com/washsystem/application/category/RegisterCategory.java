package com.washsystem.application.category;

import com.washsystem.application.Action;
import com.washsystem.domain.controller.CategoryController;

import java.util.Scanner;

public class RegisterCategory implements Action {

    private final CategoryController categoryController;

    public RegisterCategory(CategoryController categoryController) {
        this.categoryController = categoryController;
    }

    @Override
    public void exec(Scanner scanner) {
        System.out.print("CPF:      ");
        String name = scanner.nextLine();

        System.out.print("Nome:     ");
        Long price = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Email:    ");
        Long meanTime = scanner.nextLong();
        scanner.nextLine();

        this.categoryController.registerCategory(name, price, meanTime);
    }
}