package com.washsystem.infrastructure.persistence.entity;

import com.washsystem.domain.persistence.Identifiable;

import java.time.LocalDate;
import java.util.List;

public class ReportEntity implements Identifiable<Long> {

    private Long id;
    private LocalDate start;
    private LocalDate end;
    private List<Long> serviceIdList;

    public ReportEntity(Long id, LocalDate start, LocalDate end, List<Long> serviceList) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.serviceIdList = serviceList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public List<Long> getServiceList() {
        return serviceIdList;
    }

    public void setServiceList(List<Long> serviceList) {
        this.serviceIdList = serviceList;
    }
}