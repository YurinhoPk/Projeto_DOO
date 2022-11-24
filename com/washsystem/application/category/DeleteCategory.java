package com.washsystem.application.category;

import com.washsystem.application.Action;
import com.washsystem.application.Prompt;
import com.washsystem.domain.controller.CategoryController;

import java.util.Scanner;

public class DeleteCategory implements Action {

    private final CategoryController categoryController;

    public DeleteCategory(CategoryController categoryController) {
        this.categoryController = categoryController;
    }

    @Override
    public void exec(Scanner scanner) {
        Long id = Prompt.forLong(scanner, "ID");

        try {
            categoryController.deleteCategory(id);
        } catch (Exception e) {
            System.out.println("Nao foi possivel deletar a categoria: " + e.getMessage());
        }
    }
}