package com.andreitop.newco.controller;

import java.util.List;

public interface Controller<T> {
    List<T> findAll();

    T findById(final Long id);

    void create(final T t);

    void delete(final Long id);

    void update(final T t);
}
