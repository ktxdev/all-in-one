package com.ktxdev.allinone.internal.service;

public interface BaseService<D, C, U> extends BaseReaderService<D> {
    D create(C c);
    D update(U u);
    void delete(Long id);
}
