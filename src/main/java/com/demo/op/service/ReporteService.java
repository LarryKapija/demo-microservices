package com.demo.op.service;

import com.demo.op.data.EstadoReporteRepository;
import com.demo.op.data.HistoricoReporteRepository;
import com.demo.op.data.ProyectoRepository;
import com.demo.op.data.ReporteRepository;
import com.demo.op.data.entity.EstadoReporte;
import com.demo.op.data.entity.HistoricoReporte;
import com.demo.op.data.entity.Proyecto;
import com.demo.op.data.entity.Reporte;
import com.demo.op.util.NotificationsUtils;
import com.demo.op.util.model.Notificaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import static com.demo.op.util.model.EstadoReporteEnum.*;

@Service
public class ReporteService {

    @Value("${reports.minReportTime}")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    LocalTime minReportTime;
    @Value("${reports.maxReportTime}")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    LocalTime maxReportTime;
    @Autowired
    ReporteRepository reporteRepository;
    @Autowired
    ProyectoRepository proyectoRepository;
    @Autowired
    HistoricoReporteRepository historicoReporteRepository;
    @Autowired
    NotificationsUtils notificationsUtils;
    @Autowired
    EstadoReporteRepository estadoReporteRepository;

    public Reporte save(Reporte reporte) {

        reporte.setFechaCreacion(getCurrentTimeWithinBounds());

        Reporte newReporte = reporteRepository.save(reporte);
        notificationsUtils.enviarNotificacion(reporte, Notificaciones.REPORTE_RECIBIDO.toString());
        return newReporte;
    }

    public OffsetDateTime getCurrentTimeWithinBounds() {
        LocalTime timeNow = LocalTime.now();

        if(timeNow.isBefore(minReportTime))
            return OffsetDateTime.now()
                    .withHour(minReportTime.getHour())
                    .withMinute(0)
                    .withSecond(0);

        if(timeNow.isAfter(maxReportTime))
            return OffsetDateTime.now()
                    .plusDays(1L)
                    .withHour(minReportTime.getHour())
                    .withMinute(0)
                    .withSecond(0);

        return OffsetDateTime.now();
    }

    public void update(Reporte reporte){

        if(reporte.getEstado().getDescripcion().equals(ENVIADO.toString())
            && reporte.getIdProyecto()!=null) {
            estadoReporteRepository.getEstadoByDescripcion(ASIGNADO.toString())
                    .ifPresent(estado -> updateWithLog(reporte,estado));

        }

        if(reporte.getEstado().getDescripcion().equals(ASIGNADO.toString())) {
            proyectoRepository.findById(reporte.getIdProyecto()).ifPresent(proyecto -> {

                if(!proyecto.getEstado().equals(Proyecto.DEFAULT_STATUS)) {
                    estadoReporteRepository.getEstadoByDescripcion(proyecto.getEstado())
                            .ifPresent(estado -> updateWithLog(reporte,estado));
                }
                notificationsUtils.enviarNotificacion(reporte, Notificaciones.REPORTE_ASIGNADO.toString()
                        .replace("{REPORTE}", reporte.getId().toString())
                                .replace("{UNIDAD}", proyecto.getEncargado())
                        .replace("{ESTIMADO}", proyecto.getEstimadoEnMeses().toString()));
            });
        }

        if(reporte.getEstado().getDescripcion().equals(EN_PROCESO.toString())) {
            notificationsUtils.enviarNotificacion(reporte, Notificaciones.REPORTE_EN_PROGRESO.toString()
                    .replace("{REPORTE}", reporte.getId().toString()));
        }

        if(reporte.getEstado().getDescripcion().equals(TERMINADO.toString())) {
            notificationsUtils.enviarNotificacion(reporte, Notificaciones.REPORTE_COMPLETADO.toString()
                    .replace("{REPORTE}", reporte.getId().toString()));
        }
        reporteRepository.save(reporte);
    }

    private void updateWithLog(Reporte reporte, EstadoReporte estadoReporte) {
        updateLog(reporte);
        reporte.setEstado(estadoReporte);
        reporteRepository.save(reporte);
    }
    public void updateLog(Reporte reporte){
        HistoricoReporte historicoReporte = HistoricoReporte.builder()
                .idReporte(reporte.getId())
                .estado(reporte.getEstado().getDescripcion())
                .fechaCierre(OffsetDateTime.now())
                .build();
        historicoReporteRepository.save(historicoReporte);
    }

    public Optional<Reporte> findById(Long id){
        return reporteRepository.findById(id);
    }
    public List<Reporte> getReportesByTelefono(String telefono){
        return reporteRepository.getReportesByTelefono(telefono);
    }
    public List<Reporte> getReportesByProyecto(Long idProyecto){
        return  reporteRepository.getReportesByProyecto(idProyecto);
    }
    public List<Reporte> getAllActive(){
        return reporteRepository.getAllActive();
    }
}
