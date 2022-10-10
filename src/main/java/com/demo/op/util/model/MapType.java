package com.demo.op.util.model;

public enum MapType {
    ROADMAP("roadmap"),

    TERRAIN("terrain"),

    SATELLITE("satellite"),

    HYBRID("hybrid");

    private String value;

    MapType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}