package com.demo.op.data.entity;

import com.demo.op.data.entity.interfaces.Notificable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Notificable {

    @Id
    @Column(name = "USERNAME")
    private String telefono;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO")
    private String apellido;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "CORREO")
    private String correo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "USER_ROLES",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    @Builder.Default
    private Set<Role> roles = new HashSet<>();
}
