package com.washsystem.application;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Prompt {

    public static Long forLong(Scanner scanner, String label) {
        System.out.print(label + ": ");
        Long v = scanner.nextLong();
        scanner.nextLine();

        return v;
    }

    public static String forString(Scanner scanner, String label) {
        System.out.print(label + ": ");
        String v = scanner.nextLine();

        return v;
    }

    public static LocalDateTime forDateTime(Scanner scanner, String label) {
        System.out.print(label + ": ");

        String line = scanner.nextLine();

        String[] parts = line.split(" ");

        if (parts.length != 2) {
            return null;
        }

        String[] dateParts = parts[0].split("/");

        if (dateParts.length != 3) {
            return null;
        }

        String[] timeParts = parts[0].split(":");

        if (timeParts.length != 2) {
            return null;
        }

        int d = Integer.parseInt(dateParts[0]);
        int m = Integer.parseInt(dateParts[1]);
        int a = Integer.parseInt(dateParts[2]);
        int h = Integer.parseInt(timeParts[0]);
        int n = Integer.parseInt(timeParts[1]);

        return LocalDateTime.of(a, m, d, h, n, 0);
    }

    public static LocalDate forDate(Scanner scanner, String label) {
        System.out.print(label + ": ");

        String line = scanner.nextLine();

        String[] dateParts = line.split("/");

        if (dateParts.length != 3) {
            return null;
        }

        int d = Integer.parseInt(dateParts[0]);
        int m = Integer.parseInt(dateParts[1]);
        int a = Integer.parseInt(dateParts[2]);

        return LocalDate.of(a, m, d);
    }

    public static boolean forBool(Scanner scanner, String label) {
        while (true) {
            System.out.print(label + ": ");

            String opt = scanner.nextLine();

            switch (opt.toLowerCase()) {
                case "s":
                    return true;
                case "n":
                    return false;
                default:
                    System.out.println("Valor invalido. S ou N");
            }
        }
    }

    public static Long forMonetaryValue(Scanner scanner, String label) {
        while (true) {
            System.out.print(label + ": ");

            String valueStr = scanner.nextLine();
            var parts =    valueStr.split(",");

            if (parts.length == 1) {
                return Long.parseLong(parts[0]) * 10;
            } else if (parts.length == 2) {
                return Long.parseLong(parts[0]) * 10 + Long.parseLong(parts[1]);
            } else {
                System.out.println("Valor invalido");
            }
        }
    }

    public static String asMonetary(Long value) {
        var d = value/10L;
        var u = value%10L;

        return "R$ " + d + "," + u;
    }
}
