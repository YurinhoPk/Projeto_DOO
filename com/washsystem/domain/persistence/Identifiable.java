package com.washsystem.domain.persistence;

public interface Identifiable<Id> {

    Id getId();
    void setId(Id id);
}
