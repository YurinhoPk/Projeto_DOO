package com.washsystem.application;

import java.util.Scanner;

public interface Interactive {

    enum KeepRunning {
        YES,
        NO
    }

    KeepRunning run(Scanner scanner);
}
