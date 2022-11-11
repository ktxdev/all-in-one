package com.ktxdev.allinone.internal.service.impl;

import com.ktxdev.allinone.internal.exceptions.RecordNotFoundException;
import com.ktxdev.allinone.internal.repository.BaseRepository;
import com.ktxdev.allinone.internal.service.BaseReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@RequiredArgsConstructor
public class BaseReaderServiceImpl<D> implements BaseReaderService<D> {

    final BaseRepository<D> repository;

    @Override
    public Optional<D> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public D findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Record not found"));
    }

    @Override
    public Page<D> findAll(String query, Pageable pageable) {
        return repository.findAll(pageable);
    }
}
