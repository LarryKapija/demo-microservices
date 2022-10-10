package com.demo.op.data;

import com.demo.op.data.entity.EstadoReporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoReporteRepository extends JpaRepository<EstadoReporte, Long> {
    Optional<EstadoReporte> getEstadoByDescripcion(String descripcion);
}
