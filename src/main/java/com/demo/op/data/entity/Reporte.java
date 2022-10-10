package com.demo.op.data.entity;

import com.demo.op.data.entity.interfaces.Notificable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "REPORTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reporte implements Notificable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "TIPO_REPORTE")
    private String tipoReporte;

    @Column(name = "LONGITUD")
    private String longitud;

    @Column(name = "LATITUD")
    private String latitud;

    @Column(name = "NOTAS")
    private String notas;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO")
    private String apellido;

    @Column(name = "CORREO")
    private String correo;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "FECHA_CREACION")
    private OffsetDateTime fechaCreacion;

    @Column(name = "FECHA_ULTIMO_ESTADO")
    private OffsetDateTime fechaUltimoEstado;

    @Column(name = "ID_PROYECTO")
    private Long idProyecto;

    @ManyToOne
    @JoinColumn(name = "ESTADO")
    private EstadoReporte estado;
}
