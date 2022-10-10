package com.demo.op.data;

import com.demo.op.data.entity.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {
    @Query(value = "select a from Asistencia a where a.idTechnician = :idTechnician")
    List<Asistencia> getAsistenciasByTechnician(@Param("idTechnician") Long idTechnician);
    @Query(value = "select a from Asistencia a where a.estado <> 'Cerrada'")
    List<Asistencia> getAllActive();
}
