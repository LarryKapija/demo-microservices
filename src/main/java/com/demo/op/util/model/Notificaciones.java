package com.demo.op.util.model;

public enum Notificaciones {
    ASISTENCIA_CREADA("Se ha recibido su solicitud de asistencia vial, pronto sera asignada"),

    ASISTENCIA_ASIGNADA("Su solicitud de asistencia vial ha sido asignada a un tecnico"),

    ASISTENCIA_COMPLETADA("Su solicitud de asistencia vial ha sido cerrada por el tecnico, " +
            "pronto lo contactaremos para confirmar"),
    ASISTENCIA_CERRADA("Su solicitud de asistencia vial ha sido cerrada, " +
            "ha sido un placer servirle"),

    REPORTE_RECIBIDO("Hemos recibido su reporte y pronto sera asignado a una unidad, muchas gracias por su aporte para mejorar nuestras calles"),

    REPORTE_ASIGNADO("Su reporte numero {REPORTE} ha sido asignado a la unidad {UNIDAD}, " +
            "tiempo estimado de solucion(meses): {ESTIMADO}"),

    REPORTE_EN_PROGRESO("Se han iniciado las reparaciones de su reporte numero {REPORTE}"),

    REPORTE_COMPLETADO("Su gobierno lo escucha!, Su reporte numero {REPORTE} ha sido solucionado"),
    REGISTRO_OTP("Su codigo de verificacion es: ");

    private String value;

    Notificaciones(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}