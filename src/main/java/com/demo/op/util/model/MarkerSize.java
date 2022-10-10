package com.demo.op.util.model;

public enum MarkerSize {
    SMALL("tiny"),

    MEDIUM("small"),

    LARGE("mid");

    private String value;

    MarkerSize(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
