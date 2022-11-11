package com.ktxdev.allinone.internal.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BaseService<D, C, U> extends BaseReaderService<D> {
    D create(C c);
    D update(U u);
    void delete(Long id);
    Optional<D> getById(Long id);
    D findById(Long id);
    Page<D> findAll(String query, Pageable pageable);
}
