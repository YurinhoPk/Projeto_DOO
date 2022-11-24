package com.washsystem.application.vehicle;

import com.washsystem.application.Action;
import com.washsystem.application.Prompt;
import com.washsystem.domain.controller.CategoryController;
import com.washsystem.domain.controller.VehicleController;
import com.washsystem.domain.exception.EntityNotFoundException;

import java.util.Scanner;

public class DeleteVehicle implements Action {

    private final VehicleController vehicleController;

    public DeleteVehicle(VehicleController vehicleController) {
        this.vehicleController = vehicleController;
    }

    @Override
    public void exec(Scanner scanner) {
        Long id = Prompt.forLong(scanner, "ID");

        try {
            vehicleController.deleteVehicle(id);
        } catch (Exception e) {
            System.out.println("Nao foi possivel deletar o veiculo: " + e.getMessage());
        }
    }
}