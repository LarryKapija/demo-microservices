package com.demo.op.data;

import com.demo.op.data.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
    @Query(value = "select p from Proyecto p where p.estado <> 'Terminado'")
    List<Proyecto> getAllActive();
}
