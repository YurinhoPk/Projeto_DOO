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
                    .opt(1, "Abrir Caixa Registradora", new OpenCashRegister())
                    .opt(2, "Fechar Caixa Registradora", new CloseCashRegister())
                    .opt(3, "Emitir Relatorio Diario", new EmitDailyReport())
                    .opt(4, "Emitir Relatorio Entre Datas", new EmitReport())
                    .close(0)
                    .build()
            )
            .opt(
                2,
                "Menu Cliente",
                Menu
                    .builder()
                    .opt(1, "Registrar", new RegisterClient(clientController))
                    .opt(2, "Editar", new EditClient())
                    .opt(3, "Procurar", new SearchClient(clientController))
                    .opt(4, "Ativar", new ActivateClient())
                    .opt(5, "Desativar", new DeactiveteClient())
                    .opt(6, "Deletar", new DeleteClient())
                    .close(0)
                    .build()
            )
            .opt(
                3,
                "Menu Veiculo",
                Menu
                    .builder()
                    .opt(1, "Registrar", new RegisterVehicle())
                    .opt(2, "Editar", new EditVehicle())
                    .opt(3, "Procurar", new SearchVehicle())
                    .opt(4, "Deletar", new DeleteVehicle())
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
                    .opt(1, "Registrar", new RegisterService())
                    .opt(2, "Editar", new EditService())
                    .opt(3, "Procurar", new SearchService())
                    .opt(4, "Deletar", new DeleteService())
                    .close(0)
                    .build()
            )
            .opt(
                6,
                "Menu Preco e Tempo",
                Menu
                    .builder()
                    .opt(1, "Registrar", new RegisterPriceAndTime())
                    .opt(2, "Editar", new EditPriceAndTime())
                    .opt(3, "Procurar", new ListPriceAndTime())
                    .opt(4, "Deletar", new DeletePriceAndTime())
                    .close(0)
                    .build()
            )
            .opt(
                7,
                "Menu Agenda",
                Menu
                    .builder()
                    .opt(1, "Registrar", new RegisterSchedule())
                    .opt(2, "Editar", new EditSchedule())
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
