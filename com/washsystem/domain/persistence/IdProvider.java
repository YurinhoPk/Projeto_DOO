package com.washsystem.domain.persistence;

public interface IdProvider<K> {

    K next();
}
