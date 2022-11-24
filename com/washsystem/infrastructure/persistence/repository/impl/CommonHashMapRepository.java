package com.washsystem.infrastructure.persistence.repository.impl;

import com.washsystem.domain.persistence.IdProvider;
import com.washsystem.domain.persistence.Identifiable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public class CommonHashMapRepository<K, E extends Identifiable<K>, G extends IdProvider<K>> {

    private final G seqIdProvider;
    private final HashMap<K, E> table = new HashMap<K, E>();

    public CommonHashMapRepository(G seqIdProvider) {
        this.seqIdProvider = seqIdProvider;
    }

    public E create(E e) {
        e.setId(this.seqIdProvider.next());
        return this.save(e);
    }

    public E save(E e) {
        this.table.put(e.getId(), e);
        return e;
    }

    public E filterOne(Function<E, Boolean> predicate) {
        for (K k : this.table.keySet()) {
            E e = this.table.get(k);

            if (predicate.apply(e)) {
                return e;
            }
        }

        return null;
    }

    public List<E> filter(Function<E, Boolean> predicate) {
        List<E> eList = new ArrayList<>();

        for (K k : this.table.keySet()) {
            E e = this.table.get(k);

            if (predicate.apply(e)) {
                eList.add(e);
            }
        }

        return eList;
    }

    public List<E> findAll() {
        return this.table.values().stream().toList();
    }

    public E findById(K k) {
        return this.table.get(k);
    }

    public <P> E findOneByValue(P p, Function<E, P> predicate) {
        return this.filterOne((e) -> predicate.apply(e).equals(p));
    }

    public <P> List<E> findByValue(P p, Function<E, P> predicate) {
        return this.filter((e) -> predicate.apply(e).equals(p));
    }

    public <P> Long count(Function<E, Boolean> predicate) {
        long count = 0L;

        for (K k : this.table.keySet()) {
            E e = this.table.get(k);

            if (predicate.apply(e)) {
                count += 1;
            }
        }

        return count;
    }

    public <P> Long countByValue(P p, Function<E, P> predicate) {
        return this.count((e) -> predicate.apply(e) == p);
    }

    public void delete(K k) {
        this.table.remove(k);
    }
}
