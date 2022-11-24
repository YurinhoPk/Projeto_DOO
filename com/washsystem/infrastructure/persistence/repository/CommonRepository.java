package com.washsystem.infrastructure.persistence.repository;

import com.washsystem.domain.persistence.Identifiable;

import java.util.List;

public interface CommonRepository<K, M extends Identifiable<K>> {

    M create(M m);
    M save(M m);
    List<M> findAll();
    M findById(K k);
    void delete(K k);
}
