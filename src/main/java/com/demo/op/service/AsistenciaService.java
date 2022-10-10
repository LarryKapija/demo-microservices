package com.demo.op.service;

import static com.demo.op.model.AssistanceDTO.EstadoEnum.ASIGNADA;
import static com.demo.op.model.AssistanceDTO.EstadoEnum.CERRADA;
import static com.demo.op.model.AssistanceDTO.EstadoEnum.COMPLETADA;
import static com.demo.op.model.AssistanceDTO.EstadoEnum.ENVIADA;
import static com.demo.op.util.model.Notificaciones.ASISTENCIA_ASIGNADA;
import static com.demo.op.util.model.Notificaciones.ASISTENCIA_CERRADA;
import static com.demo.op.util.model.Notificaciones.ASISTENCIA_COMPLETADA;
import static com.demo.op.util.model.Notificaciones.ASISTENCIA_CREADA;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.op.data.AsistenciaRepository;
import com.demo.op.data.entity.Asistencia;
import com.demo.op.util.NotificationsUtils;

@Service
public class AsistenciaService {

    @Autowired
    AsistenciaRepository asistenciaRepository;
    @Autowired
    private NotificationsUtils notificationsUtils;

    public Asistencia save(Asistencia asistencia) {

        if(asistencia.getIdTechnician()!=null && asistencia.getEstado().equals(ENVIADA.toString()))
            asistencia.setEstado(ASIGNADA.toString());

        Asistencia newAsistencia = asistenciaRepository.save(asistencia);
        notificationsUtils.enviarNotificacion(asistencia, ASISTENCIA_CREADA.toString());


        if(asistencia.getEstado().equals(ASIGNADA.toString()))
            notificationsUtils.enviarNotificacion(asistencia, ASISTENCIA_ASIGNADA.toString());

        return newAsistencia;
    }

    public void update(Asistencia asistencia) {

        if(asistencia.getIdTechnician()!=null && asistencia.getEstado().equals(ENVIADA.toString()))
            asistencia.setEstado(ASIGNADA.toString());

        if(asistencia.getEstado().equals(CERRADA.toString()))
            asistencia.setIdTechnician(null);

        asistenciaRepository.save(asistencia);

        if(asistencia.getEstado().equals(ASIGNADA.toString()))
            notificationsUtils.enviarNotificacion(asistencia, ASISTENCIA_ASIGNADA.toString());

        if(asistencia.getEstado().equals(COMPLETADA.toString()))
            notificationsUtils.enviarNotificacion(asistencia, ASISTENCIA_COMPLETADA.toString());

        if(asistencia.getEstado().equals(CERRADA.toString()))
            notificationsUtils.enviarNotificacion(asistencia, ASISTENCIA_CERRADA.toString());
    }

    public List<Asistencia> getAllActive() {
        return asistenciaRepository.getAllActive();
    }

    public Optional<Asistencia> findById(Long id) {
        return asistenciaRepository.findById(id);
    }

    public List<Asistencia> getAsistenciasByTechnician(Long idTechnician) {
        return asistenciaRepository.getAsistenciasByTechnician(idTechnician);
    }
}
