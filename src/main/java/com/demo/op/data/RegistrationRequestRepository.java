package com.demo.op.data;

import com.demo.op.data.entity.RegistrationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationRequestRepository extends JpaRepository<RegistrationRequest, String> {
    Optional<RegistrationRequest> findByTelefono(String telefono);
    Optional<RegistrationRequest> findByCorreo(String correo);
}
