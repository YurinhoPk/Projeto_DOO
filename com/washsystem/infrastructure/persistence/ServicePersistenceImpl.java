package com.washsystem.infrastructure.persistence;

import com.washsystem.domain.model.Service;
import com.washsystem.domain.model.Vehicle;
import com.washsystem.infrastructure.persistence.entity.ServiceEntity;
import com.washsystem.infrastructure.persistence.mapper.ServiceMapper;
import com.washsystem.infrastructure.persistence.repository.ServiceRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ServicePersistenceImpl implements com.washsystem.domain.persistence.ServicePersistence {

    private final ServiceRepository serviceRepository;
    private final ServiceMapper mapper;
    private VehiclePersistenceImpl vehiclePersistenceImpl;

    public ServicePersistenceImpl(
        ServiceRepository serviceRepository,
        ServiceMapper mapper
    ) {
        this.serviceRepository = serviceRepository;
        this.mapper = mapper;
    }

    public void setVehiclePersistenceImpl(VehiclePersistenceImpl vehiclePersistenceImpl) {
        this.vehiclePersistenceImpl = vehiclePersistenceImpl;
    }

    @Override
    public Service create(Service service) {
        return this.toModel(this.serviceRepository.create(this.toEntity(service)));
    }

    @Override
    public Service save(Service service) {
        return this.toModel(this.serviceRepository.save(this.toEntity(service)));
    }

    @Override
    public List<Service> findAll() {
        return this.serviceRepository.findAll()
            .stream()
            .map(this::toModel)
            .collect(Collectors.toList());
    }

    @Override
    public Service findById(Long id) {
        return this.toModel(this.serviceRepository.findById(id));
    }

    @Override
    public void delete(Long id) {
        this.serviceRepository.delete(id);
    }

    @Override
    public Service findByVehicleIdAndType(Long id, String type) {
        return this.toModel(this.serviceRepository.findByVehicleIdAndType(id, type));
    }

    @Override
    public List<Service> findByDateBetween(LocalDate start, LocalDate end) {
        return this.serviceRepository.findByDateBetween(start, end)
            .stream()
            .map(this::toModel)
            .toList();
    }

    private ServiceEntity toEntity(Service service) {
        Vehicle vehicle = service.getVehicle();
        if (vehicle.getId() == null) {
            vehicle = this.vehiclePersistenceImpl.create(vehicle);
        } else {
            vehicle = this.vehiclePersistenceImpl.save(vehicle);
        }

        ServiceEntity serviceEntity = this.mapper.toEntity(service);
        serviceEntity.setVehicleId(vehicle.getId());

        return serviceEntity;
    }

    private Service toModel(ServiceEntity serviceEntity) {
        Vehicle vehicle = this.vehiclePersistenceImpl.findById(serviceEntity.getVehicleId());

        Service service = this.mapper.toModel(serviceEntity);
        service.setVehicle(vehicle);

        return service;
    }
}