package com.washsystem.system;

import com.washsystem.application.SystemMenu;
import com.washsystem.domain.controller.*;
import com.washsystem.infrastructure.persistence.CategoryPersistenceImpl;
import com.washsystem.infrastructure.persistence.ClientPersistenceImpl;
import com.washsystem.infrastructure.persistence.PriceAndTimePersistenceImpl;
import com.washsystem.infrastructure.persistence.ReportPersistenceImpl;
import com.washsystem.infrastructure.persistence.SchedulePersistenceImpl;
import com.washsystem.infrastructure.persistence.ServicePersistenceImpl;
import com.washsystem.infrastructure.persistence.VehiclePersistenceImpl;
import com.washsystem.infrastructure.persistence.mapper.*;
import com.washsystem.infrastructure.persistence.repository.*;
import com.washsystem.infrastructure.persistence.repository.impl.*;

import java.time.LocalDate;

class System {
    public static void main(String[] args) {
        CategoryRepository categoryRepository = new CategoryHashMapRepository();
        ClientRepository clientRepository = new ClientHashMapRepository();
        PriceAndTimeRepository priceAndTimeRepository = new PriceAndTimeHashMapRepository();
        ReportRepository reportRepository = new ReportHashMapRepository();
        ScheduleRepository scheduleRepository = new ScheduleHashMapRepository();
        ServiceRepository serviceRepository = new ServiceHashMapRepository();
        VehicleRepository vehicleRepository = new VehicleHashMapRepository();

        CategoryMapper categoryMapper = new CategoryMapper();
        ClientMapper clientMapper = new ClientMapper();
        PriceAndTimeMapper priceAndTimeMapper = new PriceAndTimeMapper();
        ReportMapper reportMapper = new ReportMapper();
        ScheduleMapper scheduleMapper = new ScheduleMapper();
        ServiceMapper serviceMapper = new ServiceMapper();
        VehicleMapper vehicleMapper = new VehicleMapper();

        CategoryPersistenceImpl categoryPersistence = new CategoryPersistenceImpl(categoryRepository, categoryMapper);
        ClientPersistenceImpl clientPersistence = new ClientPersistenceImpl(clientRepository, clientMapper);
        PriceAndTimePersistenceImpl priceAndTimePersistence = new PriceAndTimePersistenceImpl(priceAndTimeRepository, priceAndTimeMapper);
        ReportPersistenceImpl reportPersistence = new ReportPersistenceImpl(reportRepository, reportMapper);
        SchedulePersistenceImpl schedulePersistence = new SchedulePersistenceImpl(scheduleRepository, scheduleMapper);
        ServicePersistenceImpl servicePersistence = new ServicePersistenceImpl(serviceRepository, serviceMapper);
        VehiclePersistenceImpl vehiclePersistence = new VehiclePersistenceImpl(vehicleRepository, vehicleMapper);

        categoryPersistence.setPriceAndTimePersistenceImpl(priceAndTimePersistence);
        reportPersistence.setServicePersistenceImpl(servicePersistence);
        schedulePersistence.setClientPersistenceImpl(clientPersistence);
        schedulePersistence.setServicePersistenceImpl(servicePersistence);
        schedulePersistence.setVehiclePersistenceImpl(vehiclePersistence);
        schedulePersistence.setCategoryPersistence(categoryPersistence);
        servicePersistence.setVehiclePersistenceImpl(vehiclePersistence);
        vehiclePersistence.setCategoryPersistence(categoryPersistence);

        CashRegisterController cashRegisterController = new CashRegisterController(reportPersistence);
        CategoryController categoryController = new CategoryController(categoryPersistence);
        ClientController clientController = new ClientController(clientPersistence);
        PriceAndTimeController priceAndTimeController = new PriceAndTimeController(priceAndTimePersistence);
        ScheduleController scheduleController = new ScheduleController(schedulePersistence);
        ServiceController serviceController = new ServiceController(servicePersistence);
        VehicleController vehicleController = new VehicleController(vehiclePersistence);

        cashRegisterController.setServiceController(serviceController);
        categoryController.setPriceAndTimeController(priceAndTimeController);
        categoryController.setScheduleController(scheduleController);
        clientController.setScheduleController(scheduleController);
        priceAndTimeController.setCategoryController(categoryController);
        scheduleController.setCategoryController(categoryController);
        scheduleController.setClientController(clientController);
        scheduleController.setServiceController(serviceController);
        scheduleController.setVehicleController(vehicleController);
        serviceController.setScheduleController(scheduleController);
        serviceController.setVehicleController(vehicleController);
        vehicleController.setCategoryController(categoryController);
        vehicleController.setScheduleController(scheduleController);

//        // Mock
//        priceAndTimeController.registerPriceAndTime(1L, 1L);
//        categoryController.registerCategory("lava", 1L, 1L);
//        vehicleController.registerVehicle("123", "gol", "gol", "lava");
//        serviceController.registerService("123", "lava", "lava");
//        serviceController.registerService("123", "lava", "lava");
//        serviceController.registerService("123", "lava", "lava");
//
//        LocalDate s = LocalDate.now().minusDays(1L);
//        LocalDate e = LocalDate.now().plusDays(1L);
//
//        cashRegisterController.generateIntervalReport(s, e);

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