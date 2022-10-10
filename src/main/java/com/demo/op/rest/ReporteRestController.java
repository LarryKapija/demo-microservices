package com.demo.op.rest;

import com.demo.op.api.ReporteApi;
import com.demo.op.converter.DTOConverter;
import com.demo.op.data.EstadoReporteRepository;
import com.demo.op.data.FotoReporteRepository;
import com.demo.op.data.UserRepository;
import com.demo.op.data.entity.FotoReporte;
import com.demo.op.data.entity.Reporte;
import com.demo.op.data.entity.User;
import com.demo.op.model.*;
import com.demo.op.service.ReporteService;
import com.demo.op.util.StringUtils;
import com.demo.op.util.exception.NoEncontradoException;
import com.demo.op.util.exception.RequestInvalidoException;
import com.demo.op.util.model.EstadoReporteEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ReporteRestController implements ReporteApi {

    @Autowired
    ReporteService reporteService;
    @Autowired
    FotoReporteRepository fotoReporteRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    EstadoReporteRepository estadoReporteRepository;
    @Autowired
    @Qualifier("ReporteDTOConverter")
    DTOConverter<ReportDTO, Reporte> dtoConverter;

    @Override
    public ResponseEntity<ReportsResponseDTO> getAllReportes() {
        List<ReportDTO> dtoList = reporteService.getAllActive()
            .stream().map(this::mapReporteDTO).collect(Collectors.toList());

        return ResponseEntity.ok(new ReportsResponseDTO().value(dtoList));
    }

    @Override
    public ResponseEntity<LocationReportResponseDTO> getPuedeCrearReporteEnUbicacion(LocationRequestDTO locationRequestDTO) {
        LocationReportDTO ubicacionReporte = new LocationReportDTO()
                .posible(true);

        return ResponseEntity.ok(new LocationReportResponseDTO().value(ubicacionReporte));
    }

    @Override
    public ResponseEntity<ReporteResponseDTO> getReporteById(Long id) {
        return reporteService.findById(id)
                .map(this::mapReporteDTO)
                .map(dto -> ResponseEntity.ok(new ReporteResponseDTO().value(dto)))
                .orElseThrow(() -> new NoEncontradoException("Reporte no encontrado"));
    }

    @Override
    public ResponseEntity<ReportsResponseDTO> getReportesByTelefono(String telefono) {
        List<ReportDTO> dtoList = reporteService.getReportesByTelefono(telefono)
                .stream().map(this::mapReporteDTO).collect(Collectors.toList());

        return ResponseEntity.ok(new ReportsResponseDTO().value(dtoList));
    }

    @Override
    public ResponseEntity<ReporteResponseDTO> saveReporte(ReportRequestDTO reporteRequestDTO) {

        reporteRequestDTO.setTelefono(StringUtils.cleanPhoneNumber(reporteRequestDTO.getTelefono()));

        //TODO: reemplazar con el usuario logeado
        User user = userRepository.findByTelefono(reporteRequestDTO.getTelefono())
                .orElseThrow(() -> new RequestInvalidoException("Telefono no valido"));

        Reporte reporte = Reporte.builder()
                .descripcion(reporteRequestDTO.getDescripcion())
                .tipoReporte(reporteRequestDTO.getTipoReporte().getValue())
                .longitud(reporteRequestDTO.getLongitud())
                .latitud(reporteRequestDTO.getLatitud())
                .notas(reporteRequestDTO.getNotas())
                .nombre(user.getNombre())
                .apellido(user.getApellido())
                .correo(user.getCorreo())
                .telefono(reporteRequestDTO.getTelefono())
                .estado(estadoReporteRepository.getEstadoByDescripcion(EstadoReporteEnum.ENVIADO.getValue())
                        .orElseThrow(() -> new RequestInvalidoException("Estado invalido")))
                .build();
        final Reporte newReporte = reporteService.save(reporte);

        reporteRequestDTO.getFotos().forEach(urlFoto -> {
            FotoReporte fotoReporte = FotoReporte.builder()
                    .idReporte(newReporte.getId())
                    .urlFoto(urlFoto)
                    .build();
           fotoReporteRepository.save(fotoReporte);
        });

        return reporteService.findById(newReporte.getId())
                .map(this::mapReporteDTO)
                .map(dto -> ResponseEntity.ok(new ReporteResponseDTO().value(dto)))
                .orElseThrow(() -> new NoEncontradoException("Reporte no encontrado"));
    }

    @Override
    public ResponseEntity<EmptyResponseDTO> updateReporte(Long id, ReportRequestDTO reporteRequestDTO) {
        return reporteService.findById(id)
                .map(reporte -> {
                    reporte.setDescripcion(reporteRequestDTO.getDescripcion());
                    reporte.setNotas(reporteRequestDTO.getNotas());
                    reporteService.update(reporte);
                    return  ResponseEntity.ok(new EmptyResponseDTO().message("Actualizado con exito"));
                })
                .orElseThrow(() -> new NoEncontradoException("Reporte no encontrado"));
    }

    private ReportDTO mapReporteDTO(Reporte reporte) {
        return dtoConverter.build(reporte);
    }
}
