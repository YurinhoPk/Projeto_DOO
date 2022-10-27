package com.washsystem.application.category;

import com.washsystem.application.Action;
import com.washsystem.domain.controller.CategoryController;
import com.washsystem.domain.model.Category;

import java.util.List;
import java.util.Scanner;

public class ListCategory implements Action {

    private final CategoryController categoryController;

    public ListCategory(CategoryController categoryController) {
        this.categoryController = categoryController;
    }

    @Override
    public void exec(Scanner scanner) {
        List<Category> categoryList = categoryController.findAll();

        for (Category category : categoryList) {
            System.out.println("ID: " + category.getId());
            System.out.println("Nome: " + category.getName());
            System.out.println("ID Preco e Tempo: " + category.getPriceAndTimeId());
        }
    }
}