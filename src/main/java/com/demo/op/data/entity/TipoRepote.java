package com.demo.op.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TIPO_REPORTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoRepote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRIPCION")
    private String descripcion;
}
