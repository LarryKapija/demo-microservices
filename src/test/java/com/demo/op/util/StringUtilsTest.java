package com.demo.op.util;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @org.junit.jupiter.api.Test
    void limpiarTelefono() {
        String telefono = "(809) 555-5555";
        assertEquals(StringUtils.cleanPhoneNumber(telefono), "8095555555");
    }
}