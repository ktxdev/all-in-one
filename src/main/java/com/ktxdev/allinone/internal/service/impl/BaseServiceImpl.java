package com.ktxdev.allinone.internal.service.impl;

import com.ktxdev.allinone.internal.repository.BaseRepository;
import com.ktxdev.allinone.internal.service.BaseService;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public abstract class BaseServiceImpl<D, C, U> extends BaseReaderServiceImpl<D> implements BaseService<D, C, U> {
    public BaseServiceImpl(BaseRepository<D> repository) {
        super(repository);
    }

    @Override
    public void delete(Long id) {
        Optional<D> optionalD = getById(id);
        optionalD.ifPresent(repository::delete);
    }
}
