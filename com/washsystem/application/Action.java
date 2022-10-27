package com.washsystem.application;

import java.util.Scanner;

public interface Action extends Interactive {

    void exec(Scanner scanner);

    @Override
    default KeepRunning run(Scanner scanner) {
        this.exec(scanner);
        return KeepRunning.NO;
    }
}
