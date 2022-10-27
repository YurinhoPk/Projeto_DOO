package com.washsystem.domain.persistence;

import java.util.List;

public interface CommonPersistence<K, V extends Identifiable<K>> {

    V create(V v);
    V save(V v);
    List<V> findAll();
    V findById(K k);
    void delete(K k);
}
