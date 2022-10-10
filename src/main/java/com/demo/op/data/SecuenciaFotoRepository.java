package com.demo.op.data;

import com.demo.op.data.entity.SecuenciaFoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecuenciaFotoRepository extends JpaRepository<SecuenciaFoto,Long> {
   @Query(value = "select max(s.id) from SecuenciaFoto s")
   Optional<Long> getUltimaSecuencia();
}
