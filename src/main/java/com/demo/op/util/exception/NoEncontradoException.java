package com.demo.op.util.exception;

public class NoEncontradoException extends RuntimeException {
    private static final long serialVersionUID = 404L;

    public NoEncontradoException(String message) {
        super(message);
    }
}
