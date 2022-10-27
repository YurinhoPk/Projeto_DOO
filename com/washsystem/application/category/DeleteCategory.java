package com.washsystem.application.category;

import com.washsystem.application.Action;
import com.washsystem.domain.controller.CategoryController;

import java.util.Scanner;

public class DeleteCategory implements Action {

    private final CategoryController categoryController;

    public DeleteCategory(CategoryController categoryController) {
        this.categoryController = categoryController;
    }

    @Override
    public void exec(Scanner scanner) {
        System.out.println("ID: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        categoryController.deleteCategory(id);
    }
}