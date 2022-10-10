package com.demo.op.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ESTADO_REPORTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstadoReporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "DESCRIPCION_SEGUNDARIA")
    private String descripcionSegundaria;

    @Column(name = "COLOR")
    private String color;
}
