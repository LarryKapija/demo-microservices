package com.demo.op.data;

import com.demo.op.data.entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Long> {
    @Query(value = "select t from Technician t where (select count(a) from Asistencia a where t.id = a.idTechnician) = 0")
    List<Technician> getAllTechniciansSinAsignar();
    @Query(value = "select t from Technician t where " +
            "(select count(a) from Asistencia a where t.id = a.idTechnician) = 0" +
            " or t.id = :idTechnician")
    List<Technician> getAllTechniciansSinAsignar(@Param("idTechnician") Long idTechnician);

    @Query(value = "select t from Technician t where t.telefono = :telefono")
    Optional<Technician> getTechnicianByTelefono(@Param("telefono") String telefono);
}
