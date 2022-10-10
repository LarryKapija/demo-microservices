package com.demo.op.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "SOLICITUD_REGISTRO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationRequest {

    @Id
    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO")
    private String apellido;

    @Column(name = "CORREO")
    private String correo;

    @Column(name = "OTP")
    private String otp;
}
