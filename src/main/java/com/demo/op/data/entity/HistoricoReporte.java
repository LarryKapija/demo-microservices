package com.demo.op.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "HISTORICO_REPORTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoricoReporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_REPORTE")
    private Long idReporte;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "FECHA_CIERRE")
    private OffsetDateTime fechaCierre;
}
