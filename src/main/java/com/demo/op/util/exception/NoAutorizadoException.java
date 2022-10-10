package com.demo.op.util.exception;

public class NoAutorizadoException extends RuntimeException{
    private static final long serialVersionUID = 401L;

    public NoAutorizadoException(String message) {
        super(message);
    }
}
