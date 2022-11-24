package com.washsystem.infrastructure.persistence;

import com.washsystem.domain.model.Category;
import com.washsystem.domain.model.Vehicle;
import com.washsystem.domain.persistence.CategoryPersistence;
import com.washsystem.infrastructure.persistence.entity.VehicleEntity;
import com.washsystem.infrastructure.persistence.mapper.VehicleMapper;
import com.washsystem.infrastructure.persistence.repository.VehicleRepository;

import java.util.List;
import java.util.stream.Collectors;

public class VehiclePersistenceImpl implements com.washsystem.domain.persistence.VehiclePersistence {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper mapper;
    private CategoryPersistence categoryPersistence;

    public VehiclePersistenceImpl(
        VehicleRepository vehicleRepository,
        VehicleMapper mapper
    ) {
        this.vehicleRepository = vehicleRepository;
        this.mapper = mapper;
    }

    public void setCategoryPersistence(CategoryPersistence categoryPersistence) {
        this.categoryPersistence = categoryPersistence;
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        return this.toModel(this.vehicleRepository.create(this.toEntity(vehicle)));
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return this.toModel(this.vehicleRepository.save(this.toEntity(vehicle)));
    }

    @Override
    public List<Vehicle> findAll() {
        return this.vehicleRepository.findAll()
            .stream()
            .map(this::toModel)
            .collect(Collectors.toList());
    }

    @Override
    public Vehicle findById(Long id) {
        return this.toModel(this.vehicleRepository.findById(id));
    }

    @Override
    public void delete(Long id) {
        this.vehicleRepository.delete(id);
    }

    @Override
    public Vehicle findOneByPlate(String plate) {
        return this.toModel(this.vehicleRepository.findOneByPlate(plate));
    }

    private VehicleEntity toEntity(Vehicle vehicle) {
        Category category = vehicle.getCategory();
        if (category.getId() == null) {
            category = this.categoryPersistence.create(category);
        } else {
            category = this.categoryPersistence.save(category);
        }

        VehicleEntity vehicleEntity = this.mapper.toEntity(vehicle);
        vehicleEntity.setCategoryId(category.getId());

        return vehicleEntity;
    }

    private Vehicle toModel(VehicleEntity vehicleEntity) {
        Category category = this.categoryPersistence.findById(vehicleEntity.getCategoryId());

        Vehicle vehicle = this.mapper.toModel(vehicleEntity);
        vehicle.setCategory(category);

        return vehicle;
    }
}