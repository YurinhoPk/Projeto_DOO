package com.washsystem.application.vehicle;

import com.washsystem.application.Action;
import com.washsystem.application.Prompt;
import com.washsystem.domain.controller.VehicleController;
import com.washsystem.domain.exception.EntityNotFoundException;

import java.sql.SQLOutput;
import java.util.Scanner;

public class RegisterVehicle implements Action {

    private final VehicleController vehicleController;

    public RegisterVehicle(VehicleController vehicleController) {
        this.vehicleController = vehicleController;
    }

    @Override
    public void exec(Scanner scanner) {
        String plate = Prompt.forString(scanner, "Placa");
        String model = Prompt.forString(scanner, "Modelo");
        String brand = Prompt.forString(scanner, "Marca");
        String categoryName = Prompt.forString(scanner, "Categoria");

        try {
            this.vehicleController.registerVehicle(plate, model, brand, categoryName);
        } catch (Exception e) {
            System.out.println("Nao foi possivel registrar o veiculo: " + e.getMessage());
        }
    }
}