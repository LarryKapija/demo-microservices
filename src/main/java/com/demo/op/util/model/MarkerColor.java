package com.demo.op.util.model;

public enum MarkerColor {
    RED("0xff0000"),
    BLUE("0x0000ff"),
    GREEN("0x00ff00"),
    LIGHT_GRAY("0xaaaaaa"),
    DARK_GRAY("0x555555"),
    WHITE("0xffffff");

    private String value;

    MarkerColor(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}