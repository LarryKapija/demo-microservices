package com.demo.op.data;

import com.demo.op.data.entity.TipoRepote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoReporteRepository extends JpaRepository<TipoRepote, Long> {
}
