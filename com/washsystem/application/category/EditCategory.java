package com.washsystem.application.category;

import com.washsystem.application.Action;
import com.washsystem.application.Prompt;
import com.washsystem.domain.controller.CategoryController;

import java.util.Scanner;

public class EditCategory implements Action {

    private final CategoryController categoryController;

    public EditCategory(CategoryController categoryController) {
        this.categoryController = categoryController;
    }

    @Override
    public void exec(Scanner scanner) {
        Long id = Prompt.forLong(scanner, "ID");
        String name = Prompt.forString(scanner, "Nome");
        Long price = Prompt.forLong(scanner, "Preco");
        Long meanTime = Prompt.forLong(scanner, "Tempo medio");

        try {
            this.categoryController.editCategory(id, name, price, meanTime);
        } catch (Exception e) {
            System.out.println("Nao foi possivel editar a categoria: " + e.getMessage());
        }
    }
}