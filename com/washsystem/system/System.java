package com.washsystem.system;

import com.washsystem.application.SystemMenu;
import com.washsystem.domain.controller.*;
import com.washsystem.domain.persistence.*;
import com.washsystem.infrastructure.persistence.*;

class System {
    public static void main(String[] args) {
        CategoryPersistence categoryPersistence = new CategoryHashMapPersistence();
        ClientPersistence clientPersistence = new ClientHashMapPersistence();
        PriceAndTimePersistence priceAndTimePersistence = new PriceAndTimeHashMapPersistence();
        SchedulePersistence schedulePersistence = new ScheduleHashMapPersistence();
        ServicePersistence servicePersistence = new ServiceHashMapPersistence();
        VehiclePersistence vehiclePersistence = new VehicleHashMapPersistence();

        // TODO
        PriceAndTimeController priceAndTimeController = new PriceAndTimeController();

        CashRegisterController cashRegisterController = new CashRegisterController();
        ScheduleController scheduleController = new ScheduleController(schedulePersistence);
        CategoryController categoryController = new CategoryController(categoryPersistence, priceAndTimeController, scheduleController);
        ClientController clientController = new ClientController(clientPersistence, scheduleController);
        VehicleController vehicleController = new VehicleController(categoryController, vehiclePersistence, scheduleController);
        ServiceController serviceController = new ServiceController(servicePersistence, scheduleController, vehicleController);

        priceAndTimeController.setCategoryController(categoryController);
        priceAndTimeController.setPriceAndTimePersistence(priceAndTimePersistence);

        SystemMenu menu = new SystemMenu(
            cashRegisterController,
            categoryController,
            clientController,
            priceAndTimeController,
            scheduleController,
            serviceController,
            vehicleController
        );

        menu.start();
    }
}