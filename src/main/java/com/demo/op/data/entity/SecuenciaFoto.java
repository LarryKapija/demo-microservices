package com.demo.op.data.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "SECUENCIA_FOTO")
@Data
public class SecuenciaFoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
