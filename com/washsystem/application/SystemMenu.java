package com.washsystem.application;

import com.washsystem.application.cashregister.CloseCashRegister;
import com.washsystem.application.cashregister.EmitDailyReport;
import com.washsystem.application.cashregister.EmitReport;
import com.washsystem.application.cashregister.OpenCashRegister;
import com.washsystem.application.category.DeleteCategory;
import com.washsystem.application.category.EditCategory;
import com.washsystem.application.category.ListCategory;
import com.washsystem.application.category.RegisterCategory;
import com.washsystem.application.client.*;
import com.washsystem.application.priceandtime.DeletePriceAndTime;
import com.washsystem.application.priceandtime.EditPriceAndTime;
import com.washsystem.application.priceandtime.ListPriceAndTime;
import com.washsystem.application.priceandtime.RegisterPriceAndTime;
import com.washsystem.application.schedule.EditSchedule;
import com.washsystem.application.schedule.RegisterSchedule;
import com.washsystem.application.service.DeleteService;
import com.washsystem.application.service.EditService;
import com.washsystem.application.service.RegisterService;
import com.washsystem.application.service.SearchService;
import com.washsystem.application.vehicle.DeleteVehicle;
import com.washsystem.application.vehicle.EditVehicle;
import com.washsystem.application.vehicle.RegisterVehicle;
import com.washsystem.application.vehicle.SearchVehicle;
import com.washsystem.domain.controller.*;

import java.util.Scanner;

public class SystemMenu {

    private final Scanner scanner;
    private final Menu menu;

    public SystemMenu(
        CashRegisterController cashRegisterController,
        CategoryController categoryController,
        ClientController clientController,
        PriceAndTimeController priceAndTimeController,
        ScheduleController scheduleController,
        ServiceController serviceController,
        VehicleController vehicleController
    ) {
        this.scanner = new Scanner(System.in);

        this.menu = Menu
            .builder()
            .opt(
                1,
                "Menu Caixa Registradora",
                Menu
                    .builder()
                    .opt(1, "Abrir Caixa Registradora", new OpenCashRegister(cashRegisterController))
                    .opt(2, "Fechar Caixa Registradora", new CloseCashRegister(cashRegisterController))
                    .opt(3, "Emitir Relatorio Diario", new EmitDailyReport(cashRegisterController))
                    .opt(4, "Emitir Relatorio Entre Datas", new EmitReport(cashRegisterController))
                    .close(0)
                    .build()
            )
            .opt(
                2,
                "Menu Cliente",
                Menu
                    .builder()
                    .opt(1, "Registrar", new RegisterClient(clientController))
                    .opt(2, "Editar", new EditClient(clientController))
                    .opt(3, "Procurar", new SearchClient(clientController))
                    .opt(4, "Ativar", new ActivateClient(clientController))
                    .opt(5, "Desativar", new DeactiveteClient(clientController))
                    .opt(6, "Deletar", new DeleteClient(clientController))
                    .close(0)
                    .build()
            )
            .opt(
                3,
                "Menu Veiculo",
                Menu
                    .builder()
                    .opt(1, "Registrar", new RegisterVehicle(vehicleController))
                    .opt(2, "Editar", new EditVehicle(vehicleController))
                    .opt(3, "Procurar", new SearchVehicle(vehicleController))
                    .opt(4, "Deletar", new DeleteVehicle(vehicleController))
                    .close(0)
                    .build()
            )
            .opt(
                4,
                "Menu Categoria",
                Menu
                    .builder()
                    .opt(1, "Registrar", new RegisterCategory(categoryController))
                    .opt(2, "Editar", new EditCategory(categoryController))
                    .opt(3, "Procurar", new ListCategory(categoryController))
                    .opt(4, "Deletar", new DeleteCategory(categoryController))
                    .close(0)
                    .build()
            )
            .opt(
                5,
                "Menu Servico",
                Menu
                    .builder()
                    .opt(1, "Registrar", new RegisterService(serviceController))
                    .opt(2, "Editar", new EditService(serviceController))
                    .opt(3, "Procurar", new SearchService(serviceController))
                    .opt(4, "Deletar", new DeleteService(serviceController))
                    .close(0)
                    .build()
            )
            .opt(
                6,
                "Menu Preco e Tempo",
                Menu
                    .builder()
                    .opt(1, "Registrar", new RegisterPriceAndTime(priceAndTimeController))
                    .opt(2, "Editar", new EditPriceAndTime(priceAndTimeController))
                    .opt(3, "Procurar", new ListPriceAndTime(priceAndTimeController))
                    .opt(4, "Deletar", new DeletePriceAndTime(priceAndTimeController))
                    .close(0)
                    .build()
            )
            .opt(
                7,
                "Menu Agenda",
                Menu
                    .builder()
                    .opt(1, "Registrar", new RegisterSchedule(scheduleController))
                    .opt(2, "Editar", new EditSchedule(scheduleController))
                    .close(0)
                    .build()
            )
            .close(0)
            .build();
    }

    public void start() {
        while (this.menu.run(this.scanner) == Interactive.KeepRunning.YES) {}
    }
}
