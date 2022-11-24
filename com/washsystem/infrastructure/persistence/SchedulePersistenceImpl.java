package com.washsystem.infrastructure.persistence;

import com.washsystem.domain.model.*;
import com.washsystem.domain.persistence.CategoryPersistence;
import com.washsystem.infrastructure.persistence.entity.ScheduleEntity;
import com.washsystem.infrastructure.persistence.mapper.ScheduleMapper;
import com.washsystem.infrastructure.persistence.repository.ScheduleRepository;

import java.util.List;
import java.util.stream.Collectors;

public class SchedulePersistenceImpl implements com.washsystem.domain.persistence.SchedulePersistence {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper mapper;
    private ClientPersistenceImpl clientPersistenceImpl;
    private ServicePersistenceImpl servicePersistenceImpl;
    private VehiclePersistenceImpl vehiclePersistenceImpl;
    private CategoryPersistence categoryPersistence;

    public SchedulePersistenceImpl(
        ScheduleRepository scheduleRepository,
        ScheduleMapper mapper
    ) {
        this.scheduleRepository = scheduleRepository;
        this.mapper = mapper;
    }

    public void setClientPersistenceImpl(ClientPersistenceImpl clientPersistenceImpl) {
        this.clientPersistenceImpl = clientPersistenceImpl;
    }

    public void setServicePersistenceImpl(ServicePersistenceImpl servicePersistenceImpl) {
        this.servicePersistenceImpl = servicePersistenceImpl;
    }

    public void setVehiclePersistenceImpl(VehiclePersistenceImpl vehiclePersistenceImpl) {
        this.vehiclePersistenceImpl = vehiclePersistenceImpl;
    }

    public void setCategoryPersistence(CategoryPersistence categoryPersistence) {
        this.categoryPersistence = categoryPersistence;
    }

    @Override
    public Schedule create(Schedule schedule) {
        return this.toModel(this.scheduleRepository.create(this.toEntity(schedule)));
    }

    @Override
    public Schedule save(Schedule schedule) {
        return this.toModel(this.scheduleRepository.save(this.toEntity(schedule)));
    }

    @Override
    public List<Schedule> findAll() {
        return this.scheduleRepository.findAll()
            .stream()
            .map(this::toModel)
            .collect(Collectors.toList());
    }

    @Override
    public Schedule findById(Long id) {
        return this.toModel(this.scheduleRepository.findById(id));
    }

    @Override
    public void delete(Long id) {
        this.scheduleRepository.delete(id);
    }

    @Override
    public Long countByCategoryId(Long id) {
        return this.scheduleRepository.countByCategoryId(id);
    }

    @Override
    public Long countByClientId(Long id) {
        return this.scheduleRepository.countByClientId(id);
    }

    @Override
    public Long countByServiceId(Long id) {
        return this.scheduleRepository.countByServiceId(id);
    }

    @Override
    public Long countByVehicleId(Long id) {
        return this.scheduleRepository.countByVehicleId(id);
    }

    private ScheduleEntity toEntity(Schedule schedule) {
        Client client = schedule.getClient();
        if (client.getId() == null) {
            client = this.clientPersistenceImpl.create(client);
        } else {
            client = this.clientPersistenceImpl.save(client);
        }

        Service service = schedule.getService();
        if (service.getId() == null) {
            service = this.servicePersistenceImpl.create(service);
        } else {
            service = this.servicePersistenceImpl.save(service);
        }

        Vehicle vehicle = schedule.getVehicle();
        if (vehicle.getId() == null) {
            vehicle = this.vehiclePersistenceImpl.create(vehicle);
        } else {
            vehicle = this.vehiclePersistenceImpl.save(vehicle);
        }

        Category category = schedule.getCategory();
        if (category.getId() == null) {
            category = this.categoryPersistence.create(category);
        } else {
            category = this.categoryPersistence.save(category);
        }

        ScheduleEntity scheduleEntity = this.mapper.toEntity(schedule);
        scheduleEntity.setClientId(client.getId());
        scheduleEntity.setServiceId(service.getId());
        scheduleEntity.setVehicleId(vehicle.getId());
        scheduleEntity.setCategoryId(category.getId());

        return scheduleEntity;
    }

    private Schedule toModel(ScheduleEntity scheduleEntity) {
        Client client = this.clientPersistenceImpl.findById(scheduleEntity.getClientId());
        Service service = this.servicePersistenceImpl.findById(scheduleEntity.getServiceId());
        Vehicle vehicle = this.vehiclePersistenceImpl.findById(scheduleEntity.getVehicleId());
        Category category = this.categoryPersistence.findById(scheduleEntity.getCategoryId());

        Schedule schedule = this.mapper.toModel(scheduleEntity);
        schedule.setClient(client);
        schedule.setService(service);
        schedule.setVehicle(vehicle);
        schedule.setCategory(category);

        return schedule;
    }
}