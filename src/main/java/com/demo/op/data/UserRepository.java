package com.demo.op.data;

import com.demo.op.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByTelefono(String telefono);
    Boolean existsByTelefono(String telefono);
    Boolean existsByCorreo(String correo);
}
