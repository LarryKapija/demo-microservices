package com.demo.op.data;

import com.demo.op.data.entity.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReporteRepository extends JpaRepository<Reporte, Long> {
    @Query(value = "select r from Reporte r where r.telefono = :telefono")
    List<Reporte> getReportesByTelefono(@Param("telefono") String telefono);
    @Query(value = "select r from Reporte r where r.idProyecto = :idProyecto")
    List<Reporte> getReportesByProyecto(@Param("idProyecto") Long idProyecto);
    @Query(value = "select r from Reporte r where r.estado.descripcion <> 'Terminado'")
    List<Reporte> getAllActive();
}
