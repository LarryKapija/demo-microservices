package com.demo.op.data.entity;

import com.demo.op.data.entity.interfaces.Notificable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.OffsetDateTime;

@Entity
@Table(name = "ASISTENCIA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asistencia implements Notificable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "NOMBRE")
    @NotBlank(message = "El Nombre es obligatorio")
    private String nombre;

    @Column(name = "APELLIDO")
    @NotBlank(message = "El Apellido es obligatorio")
    private String apellido;

    @Column(name = "TELEFONO")
    @NotBlank(message = "El Telefono es obligatorio")
    private String telefono;

    @Column(name = "TIPO_SITUACION")
    @NotBlank(message = "El Tipo de situacion es obligatorio")
    private String tipoSituacion;

    @Column(name = "SITUACION")
    private String situacion;

    @Column(name = "PLACA")
    @NotBlank(message = "La Placa es obligatoria")
    private String placa;

    @Column(name = "TIPO_VEHICULO")
    private String tipoVehiculo;

    @Column(name = "MARCA")
    private String marca;

    @Column(name = "MODELO")
    private String modelo;

    @Column(name = "COLOR")
    private String color;

    @Column(name = "FECHA_LLAMADA")
    private OffsetDateTime fechaLlamada;

    @Column(name = "FECHA_ASISTENCIA")
    private OffsetDateTime fechaAsistencia;

    @Column(name = "URL_IMAGEN_FIRMA")
    private String urlImagenFirma;

    @Column(name = "LATITUD")
    private String latitud;

    @Column(name = "LONGITUD")
    private String longitud;

    @Column(name = "ID_TECNICO")
    private Long idTechnician;

    @Column(name = "NOTAS_TECNICO")
    private String notasTechnician;

    @Column(name = "ESTADO")
    private String estado;

    @Override
    public String getCorreo() {
        return null;
    }
}
