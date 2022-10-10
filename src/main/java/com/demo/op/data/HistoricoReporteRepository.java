package com.demo.op.data;

import com.demo.op.data.entity.HistoricoReporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricoReporteRepository extends JpaRepository<HistoricoReporte, Long> {
    List<HistoricoReporte> findByIdReporte(Long idReporte);
}
