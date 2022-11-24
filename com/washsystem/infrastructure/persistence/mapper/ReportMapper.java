package com.washsystem.infrastructure.persistence.mapper;

import com.washsystem.domain.model.Report;
import com.washsystem.infrastructure.persistence.entity.ReportEntity;

public class ReportMapper implements Mapper<Long, Report, ReportEntity> {

    @Override
    public Report toModel(ReportEntity reportEntity) {
        return new Report(
            reportEntity.getId(),
            reportEntity.getStart(),
            reportEntity.getEnd(),
            null
        );
    }

    @Override
    public ReportEntity toEntity(Report report) {
        return new ReportEntity(
            report.getId(),
            report.getStart(),
            report.getEnd(),
            null
        );
    }
}
