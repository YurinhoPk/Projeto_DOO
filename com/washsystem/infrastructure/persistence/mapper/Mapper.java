package com.washsystem.infrastructure.persistence.mapper;

import com.washsystem.domain.persistence.Identifiable;

public interface Mapper<K, M extends Identifiable<K>, E extends Identifiable<K>> {
    M toModel(E e);
    E toEntity(M m);
}
