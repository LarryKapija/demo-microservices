package com.demo.op.util.exception;

public class RequestInvalidoException extends RuntimeException{
    private static final long serialVersionUID = 400L;

    public RequestInvalidoException(String message) {
        super(message);
    }
}
