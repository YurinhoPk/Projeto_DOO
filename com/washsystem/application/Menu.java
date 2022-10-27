package com.washsystem.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu implements Interactive {

    private String title = "";
    private final List<MenuOpt> children;
    private final Integer closeOpt;

    record MenuOpt(int opt, String title, Interactive child) {}

    static class MenuBuilder {

        private final List<MenuOpt> children = new ArrayList<>();
        private Integer closeOpt = null;

        public MenuBuilder opt(int opt, String title, Interactive child) {
            this.children.add(new MenuOpt(opt, title, child));

            if (child instanceof Menu) {
                ((Menu)child).setTitle(title);
            }

            return this;
        }

        public MenuBuilder close(int opt) {
            this.closeOpt = opt;
            return this;
        }

        public Menu build() {
            return new Menu(this.children, this.closeOpt);
        }
    }

    Menu(List<MenuOpt> children, Integer closeOpt) {
        this.children = children;
        this.closeOpt = closeOpt;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public static MenuBuilder builder() {
        return new MenuBuilder();
    }

    public KeepRunning run(Scanner scanner) {
        if (this.children.size() == 0) {
            return KeepRunning.NO;
        }

        // Print
        System.out.println("-----" + padTitle(this.title));

        for (MenuOpt menuOpt : this.children) {
            System.out.println(menuOpt.opt() + ". " + menuOpt.title());
        }

        if (this.closeOpt != null) {
            System.out.println("");

            System.out.println(this.closeOpt + ". Voltar");
        }

        System.out.println("---------------------------------------------");

        // Scan number
        System.out.println("> ");
        int chosen = scanner.nextInt();

        // Consume end line
        scanner.nextLine();

        System.out.println("");

        // Match
        for (MenuOpt menuOpt : this.children) {
            if (menuOpt.opt() == chosen) {
                while (menuOpt.child.run(scanner) == KeepRunning.YES) {}
                break;
            }
        }

        if (this.closeOpt != null && this.closeOpt == chosen) {
            return KeepRunning.NO;
        }

        return KeepRunning.YES;
    }

    private String padTitle(String title) {
        StringBuilder builder = new StringBuilder();

        if (title.length() > 0) {
            builder.append(" ");
            builder.append(title);
            builder.append(" ");
        }

        while (builder.length() < 40) {
            builder.append('-');
        }

        return builder.toString();
    }
}
