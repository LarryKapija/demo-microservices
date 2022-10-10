package com.demo.op.converter;

public interface DTOConverter <D, E> {
    D build(E entity);
}
