package com.washsystem.infrastructure.persistence;

import com.washsystem.domain.model.Report;
import com.washsystem.domain.model.Service;
import com.washsystem.infrastructure.persistence.entity.ReportEntity;
import com.washsystem.infrastructure.persistence.mapper.ReportMapper;
import com.washsystem.infrastructure.persistence.repository.ReportRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ReportPersistenceImpl implements com.washsystem.domain.persistence.ReportPersistence {

    private final ReportRepository reportRepository;
    private final ReportMapper mapper;
    private ServicePersistenceImpl servicePersistenceImpl;

    public ReportPersistenceImpl(
        ReportRepository reportRepository,
        ReportMapper mapper
    ) {
        this.reportRepository = reportRepository;
        this.mapper = mapper;
    }

    public void setServicePersistenceImpl(ServicePersistenceImpl servicePersistenceImpl) {
        this.servicePersistenceImpl = servicePersistenceImpl;
    }

    @Override
    public Report create(Report report) {
        return this.toModel(this.reportRepository.create(this.toEntity(report)));
    }

    @Override
    public Report save(Report report) {
        return this.toModel(this.reportRepository.save(this.toEntity(report)));
    }

    @Override
    public List<Report> findAll() {
        return this.reportRepository.findAll()
            .stream()
            .map(this::toModel)
            .collect(Collectors.toList());
    }

    @Override
    public Report findById(Long id) {
        return this.toModel(this.reportRepository.findById(id));
    }

    @Override
    public void delete(Long id) {
        this.reportRepository.delete(id);
    }

    private ReportEntity toEntity(Report report) {
        List<Service> serviceList = report.getServiceList()
            .stream()
            .map((service) -> {
                if (service.getId() == null) {
                    return this.servicePersistenceImpl.create(service);
                } else {
                    return this.servicePersistenceImpl.save(service);
                }
            })
            .toList();

        ReportEntity reportEntity = this.mapper.toEntity(report);
        reportEntity.setServiceList(
            serviceList
                .stream()
                .map(Service::getId)
                .toList()
        );

        return reportEntity;
    }

    private Report toModel(ReportEntity reportEntity) {
        List<Service> serviceList = reportEntity.getServiceList()
            .stream()
            .map(this.servicePersistenceImpl::findById)
            .toList();

        Report report = this.mapper.toModel(reportEntity);
        report.setServiceList(serviceList);

        return report;
    }
}
