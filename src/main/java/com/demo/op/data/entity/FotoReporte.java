package com.demo.op.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "FOTOS_REPORTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FotoReporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_REPORTE")
    private Long idReporte;

    @Column(name = "URL_FOTO")
    private String urlFoto;

}
