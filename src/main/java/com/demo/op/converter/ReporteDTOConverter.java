package com.demo.op.converter;

import com.demo.op.data.EstadoReporteRepository;
import com.demo.op.data.FotoReporteRepository;
import com.demo.op.data.HistoricoReporteRepository;
import com.demo.op.data.entity.EstadoReporte;
import com.demo.op.data.entity.FotoReporte;
import com.demo.op.data.entity.HistoricoReporte;
import com.demo.op.data.entity.Reporte;
import com.demo.op.model.ReportStateDetailDTO;
import com.demo.op.model.EstadoReporteDTO;
import com.demo.op.model.ReportDTO;
import com.demo.op.util.model.EstadoReporteEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("ReporteDTOConverter")
public class ReporteDTOConverter implements DTOConverter<ReportDTO, Reporte> {

    @Autowired
    private EstadoReporteRepository estadoReporteRepository;
    @Autowired
    private FotoReporteRepository fotoReporteRepository;
    @Autowired
    private HistoricoReporteRepository historicoReporteRepository;

    @Override
    public ReportDTO build(Reporte entity) {
        return new ReportDTO()
                .id(entity.getId())
                .descripcion(entity.getDescripcion())
                .tipoReporte(entity.getTipoReporte())
                .longitud(entity.getLongitud())
                .latitud(entity.getLatitud())
                .notas(entity.getNotas())
                .nombre(entity.getNombre())
                .apellido(entity.getApellido())
                .correo(entity.getCorreo())
                .telefono(entity.getTelefono())
                .fechaCreacion(entity.getFechaCreacion())
                .fechaUltActualizacion(entity.getFechaUltimoEstado())
                .fotos(fotoReporteRepository.findByIdReporte(entity.getId())
                        .stream().map(FotoReporte::getUrlFoto).collect(Collectors.toList()))
                .estado(mapEstado(entity));
    }

    private EstadoReporteDTO mapEstado(Reporte reporte) {

        List<HistoricoReporte> historico = historicoReporteRepository.findByIdReporte(reporte.getId());
        EstadoReporteDTO estadoReporteDTO = new EstadoReporteDTO()
                .descripcion(reporte.getEstado().getDescripcion())
                .descripcionSecundaria(reporte.getEstado().getDescripcionSegundaria())
                .color(reporte.getEstado().getColor())
                .detalle(historico.stream().map(this::mapDetalleEstado).collect(Collectors.toList()));

        estadoReporteDTO.addDetalleItem(mapDetalleEstado(reporte));

        estadoReporteRepository.findAll().stream()
                .filter(estadoReporte -> !estadoReporte.equals(reporte.getEstado()))
                .filter(estadoReporte -> historico.stream().
                        noneMatch(historicoReporte -> historicoReporte.getEstado().equals(estadoReporte.getDescripcion())))
                .map(this::mapDetalleEstado)
                .forEach(estadoReporteDTO::addDetalleItem);

        float porcentajeCompletado = 0.0F;
        switch (EstadoReporteEnum.fromValue(reporte.getEstado().getDescripcion())) {
            case ASIGNADO: porcentajeCompletado = 15.0F;
                break;
            case EN_PROCESO: porcentajeCompletado = 60.0F;
                break;
            case TERMINADO: porcentajeCompletado = 100.0F;
                break;
            default:
                break;
        }

        estadoReporteDTO.setPorcentajeCompletado(porcentajeCompletado);

        return estadoReporteDTO;
    }

    private ReportStateDetailDTO mapDetalleEstado(HistoricoReporte historico) {
        return new ReportStateDetailDTO()
                .nombre(historico.getEstado())
                .fechaFinal(historico.getFechaCierre());
    }

    private ReportStateDetailDTO mapDetalleEstado(Reporte reporte) {
        return new ReportStateDetailDTO()
                .nombre(reporte.getEstado().getDescripcion())
                .fechaInicio(reporte.getFechaCreacion());
    }

    private ReportStateDetailDTO mapDetalleEstado(EstadoReporte estadoReporte) {
        return new ReportStateDetailDTO()
                .nombre(estadoReporte.getDescripcion());
    }
}
