package com.demo.op.converter;

import com.demo.op.data.entity.Asistencia;
import com.demo.op.model.AssistanceDTO;
import org.springframework.stereotype.Component;

@Component("AsistenciaDTOConverter")
public class AsistenciaDTOConverter implements DTOConverter<AssistanceDTO, Asistencia> {
    @Override
    public AssistanceDTO build(Asistencia entity) {
        return new AssistanceDTO()
                .id(entity.getId())
                .fechaLlamada(entity.getFechaLlamada())
                .fechaAsistencia(entity.getFechaAsistencia())
                .nombre(entity.getNombre())
                .apellido(entity.getApellido())
                .telefono(entity.getTelefono())
                .tipoSituacion(entity.getTipoSituacion())
                .situacion(entity.getSituacion())
                .placa(entity.getPlaca())
                .tipoVehiculo(entity.getTipoVehiculo())
                .marca(entity.getMarca())
                .modelo(entity.getModelo())
                .color(entity.getColor())
                .urlImagenFirma(entity.getUrlImagenFirma())
                .latitud(entity.getLatitud())
                .longitud(entity.getLongitud())
                .idTechnician(entity.getIdTechnician())
                .notasTechnician(entity.getNotasTechnician())
                .estado(AssistanceDTO.EstadoEnum.fromValue(entity.getEstado()));
    }
}
