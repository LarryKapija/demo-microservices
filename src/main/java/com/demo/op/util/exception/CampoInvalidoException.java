package com.demo.op.util.exception;

public class CampoInvalidoException extends RuntimeException{
    private static final long serialVersionUID = 400L;
    private String field;
    private String message;

    public CampoInvalidoException(String field, String message) {
        super(field+":"+message);
        this.field = field;
        this.message = message;
    }

    public String field() {
        return field;
    }


    public String message(){
        return message;
    }
}
