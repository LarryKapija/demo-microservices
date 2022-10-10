package com.demo.op.service;

import com.demo.op.data.EstadoReporteRepository;
import com.demo.op.data.ProyectoRepository;
import com.demo.op.data.entity.Proyecto;
import com.demo.op.util.model.EstadoReporteEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoService {
    @Autowired
    ProyectoRepository proyectoRepository;
    @Autowired
    EstadoReporteRepository estadoReporteRepository;
    @Autowired
    ReporteService reporteService;

    public Proyecto save(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }
    public void update(Proyecto proyecto) {
        proyectoRepository.save(proyecto);
        if(proyecto.getEstado().equals(EstadoReporteEnum.EN_PROCESO.getValue())
            || proyecto.getEstado().equals(EstadoReporteEnum.TERMINADO.getValue())) {
            reporteService.getReportesByProyecto(proyecto.getId()).forEach(reporte -> {
                String estadoProyecto = proyecto.getEstado();
                if(!reporte.getEstado().getDescripcion().equals(estadoProyecto)) {
                    reporteService.updateLog(reporte);
                    estadoReporteRepository.getEstadoByDescripcion(estadoProyecto)
                                    .ifPresent(reporte::setEstado);
                    reporteService.update(reporte);
                }
            });
        }
    }
    public Optional<Proyecto> findById(Long id){
        return  proyectoRepository.findById(id);
    }
    public List<Proyecto> getAllActive(){
        return  proyectoRepository.getAllActive();
    }

}
