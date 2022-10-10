package com.demo.op.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "PROYECTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Proyecto {

    public final static String DEFAULT_STATUS = "Registrado";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "NOTAS")
    private String notas;

    @Column(name = "ESTIMADO_MESES")
    private Long estimadoEnMeses;

    @Column(name = "ENCARGADO")
    private String encargado;

    @Column(name = "FECHA_CREACION")
    private OffsetDateTime fechaCreacion;

    @Column(name = "ESTADO")
    private String estado;
}
