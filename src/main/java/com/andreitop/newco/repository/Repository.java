package com.andreitop.newco.repository;

import com.andreitop.newco.dto.TripDto;

import java.util.ArrayList;
import java.util.List;

public interface Repository<T> {
    List<T> findAll();

    T findById(final Long id);

    void save(final T trip);

    void delete(final Long id);

    void update(final T newT);
}
