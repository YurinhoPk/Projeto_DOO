package com.washsystem.application.vehicle;

import com.washsystem.application.Action;
import com.washsystem.application.Prompt;
import com.washsystem.domain.controller.VehicleController;
import com.washsystem.domain.exception.EntityNotFoundException;
import com.washsystem.domain.model.Vehicle;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class SearchVehicle implements Action {

    private final VehicleController vehicleController;

    public SearchVehicle(VehicleController vehicleController) {
        this.vehicleController = vehicleController;
    }

    @Override
    public void exec(Scanner scanner) {
        String plate = Prompt.forString(scanner, "Placa");

        try {
            Vehicle vehicle = this.vehicleController.findOneByPlate(plate);

            System.out.println();
            System.out.println("ID: " + vehicle.getId());
            System.out.println("Placa: " + vehicle.getPlate());
            System.out.println("Modelo: " + vehicle.getModel());
            System.out.println("Marca: " + vehicle.getBrand());
            System.out.println("ID da Categoria: " + vehicle.getCategory().getId());
            System.out.println();
        } catch (Exception e) {
            System.out.println("O veiculo nao foi encontrado: " + e.getMessage());
        }
    }
}