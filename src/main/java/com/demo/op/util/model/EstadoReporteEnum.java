package com.demo.op.util.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EstadoReporteEnum {
    ENVIADO("Enviado"),

    ASIGNADO("Asignado"),

    EN_PROCESO("En Proceso"),

    TERMINADO("Terminado");

    private String value;

    EstadoReporteEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static EstadoReporteEnum fromValue(String value) {
        for (EstadoReporteEnum b : EstadoReporteEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}