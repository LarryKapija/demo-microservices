package com.demo.op.data;

import com.demo.op.data.entity.FotoReporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FotoReporteRepository extends JpaRepository<FotoReporte,Long> {
    List<FotoReporte> findByIdReporte(Long idReporte);
}
