package com.washsystem.domain.model;

import com.washsystem.domain.persistence.Identifiable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Report implements Identifiable<Long> {

    private Long id;
    private LocalDate start;
    private LocalDate end;
    private List<Service> serviceList;

    public Report(LocalDate start, LocalDate end, List<Service> serviceList) {
        this.start = start;
        this.end = end;
        this.serviceList = serviceList;
    }

    public Report(Long id, LocalDate start, LocalDate end, List<Service> serviceList) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.serviceList = serviceList;
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

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }
}