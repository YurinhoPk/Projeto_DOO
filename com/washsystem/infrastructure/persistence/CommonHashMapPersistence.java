package com.washsystem.infrastructure.persistence;

import com.washsystem.domain.persistence.IdProvider;
import com.washsystem.domain.persistence.Identifiable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public class CommonHashMapPersistence<K, V extends Identifiable<K>, G extends IdProvider<K>> {

    private final G seqIdProvider;
    private final HashMap<K, V> table = new HashMap<K, V>();

    public CommonHashMapPersistence(G seqIdProvider) {
        this.seqIdProvider = seqIdProvider;
    }

    public V create(V v) {
        v.setId(this.seqIdProvider.next());
        return this.save(v);
    }

    public V save(V v) {
        this.table.put(v.getId(), v);
        return v;
    }

    public V filterOne(Function<V, Boolean> predicate) {
        for (K k : this.table.keySet()) {
            V v = this.table.get(k);

            if (predicate.apply(v)) {
                return v;
            }
        }

        return null;
    }

    public List<V> filter(Function<V, Boolean> predicate) {
        List<V> vList = new ArrayList<>();

        for (K k : this.table.keySet()) {
            V v = this.table.get(k);

            if (predicate.apply(v)) {
                vList.add(v);
            }
        }

        return vList;
    }

    public List<V> findAll() {
        return this.table.values().stream().toList();
    }

    public V findById(K k) {
        return this.table.get(k);
    }

    public <P> V findOneByValue(P p, Function<V, P> predicate) {
        return this.filterOne((v) -> predicate.apply(v).equals(p));
    }

    public <P> List<V> findByValue(P p, Function<V, P> predicate) {
        return this.filter((v) -> predicate.apply(v).equals(p));
    }

    public <P> Long count(Function<V, Boolean> predicate) {
        long count = 0L;

        for (K k : this.table.keySet()) {
            V v = this.table.get(k);

            if (predicate.apply(v)) {
                count += 1;
            }
        }

        return count;
    }

    public <P> Long countByValue(P p, Function<V, P> predicate) {
        return this.count((v) -> predicate.apply(v) == p);
    }

    public void delete(K k) {
        this.table.remove(k);
    }
}
