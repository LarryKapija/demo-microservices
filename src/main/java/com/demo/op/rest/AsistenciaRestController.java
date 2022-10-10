package com.demo.op.rest;

import com.demo.op.api.AsistenciaApi;
import com.demo.op.converter.DTOConverter;
import com.demo.op.data.TechnicianRepository;
import com.demo.op.data.entity.Asistencia;
import com.demo.op.data.entity.Technician;
import com.demo.op.model.*;
import com.demo.op.service.AsistenciaService;
import com.demo.op.util.StringUtils;
import com.demo.op.util.exception.NoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AsistenciaRestController implements AsistenciaApi {

    @Autowired
    AsistenciaService asistenciaService;
    @Autowired
    private TechnicianRepository tecnicoRepository;
    @Autowired
    @Qualifier("AsistenciaDTOConverter")
    private DTOConverter<AssistanceDTO, Asistencia> dtoConverter;
    @Autowired
    @Qualifier("TechnicianDTOConverter")
    private DTOConverter<TechnicianDTO, Technician> tecnicoDTOConverter;

    @Override
    public ResponseEntity<AsistancesResponseDTO> getAllAsistencias() {
        List<AssistanceDTO> dtoList = asistenciaService.getAllActive()
                .stream().map(this::mapAsistenciaDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new AsistancesResponseDTO().value(dtoList));
    }

    @Override
    public ResponseEntity<AsistanceResponseDTO> getAsistenciaById(Long id) {
        return asistenciaService.findById(id)
                .map(this::mapAsistenciaDTO)
                .map(dto -> ResponseEntity.ok(new AsistanceResponseDTO().value(dto)))
                .orElseThrow(() -> new NoEncontradoException("Asistencia no encontrada"));
    }

    @Override
    public ResponseEntity<AsistancesResponseDTO> getAsistenciasByTechnician(Long idTechnician) {
        List<AssistanceDTO> dtoList = asistenciaService.getAsistenciasByTechnician(idTechnician)
                .stream().map(this::mapAsistenciaDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new AsistancesResponseDTO().value(dtoList));
    }

    @Override
    public ResponseEntity<AsistanceResponseDTO> saveAsistencia(AsistanceRequestDTO asistenciaRequestDTO) {

        asistenciaRequestDTO.setTelefono(StringUtils.cleanPhoneNumber(asistenciaRequestDTO.getTelefono()));

        Asistencia asistencia = Asistencia.builder()
                .nombre(asistenciaRequestDTO.getNombre())
                .apellido(asistenciaRequestDTO.getApellido())
                .telefono(asistenciaRequestDTO.getTelefono())
                .tipoSituacion(asistenciaRequestDTO.getTipoSituacion())
                .situacion(asistenciaRequestDTO.getSituacion())
                .placa(asistenciaRequestDTO.getPlaca())
                .tipoVehiculo(asistenciaRequestDTO.getTipoVehiculo())
                .marca(asistenciaRequestDTO.getMarca())
                .modelo(asistenciaRequestDTO.getModelo())
                .color(asistenciaRequestDTO.getColor())
                .fechaLlamada(OffsetDateTime.now())
                .latitud(asistenciaRequestDTO.getLatitud())
                .longitud(asistenciaRequestDTO.getLongitud())
                .estado(AssistanceDTO.EstadoEnum.ENVIADA.getValue())
                .build();
        asistencia = asistenciaService.save(asistencia);
        return ResponseEntity.ok(new AsistanceResponseDTO().value(dtoConverter.build(asistencia)));
    }

    @Override
    public ResponseEntity<EmptyResponseDTO> updateAsistencia(Long id, AsistanceRequestDTO asistenciaRequestDTO) {
        return asistenciaService.findById(id)
                .map(asistencia -> {
                    asistencia.setFechaAsistencia(asistenciaRequestDTO.getFechaAsistencia());
                    asistencia.setIdTechnician(asistenciaRequestDTO.getIdTechnician());
                    asistencia.setEstado(asistenciaRequestDTO.getEstado().getValue());
                    asistencia.setUrlImagenFirma(asistenciaRequestDTO.getUrlImagenFirma());
                    asistenciaService.update(asistencia);
                    return ResponseEntity.ok(new EmptyResponseDTO().message("Actualizado con exito"));
                })
                .orElseThrow(() -> new NoEncontradoException("Asistencia no encontrada"));
    }

    @Override
    public ResponseEntity<EmptyResponseDTO> updateEstadoAsistencia(Long id, AssistanceStatusRequestDTO estadoAsistenciaRequestDTO) {
        return asistenciaService.findById(id)
                .map(asistencia -> {
                    asistencia.setNotasTechnician(estadoAsistenciaRequestDTO.getNotasTechnician());
                    asistencia.setUrlImagenFirma(estadoAsistenciaRequestDTO.getUrlImagenFirma());
                    asistencia.setEstado(estadoAsistenciaRequestDTO.getEstado().getValue());
                    asistenciaService.update(asistencia);

                    return ResponseEntity.ok(new EmptyResponseDTO().message("Actualizado con exito"));
                })
                .orElseThrow(() -> new NoEncontradoException("Asistencia no encontrada"));
    }

    private AssistanceDTO mapAsistenciaDTO(Asistencia asistencia) {
        TechnicianDTO tecnicoDTO = tecnicoRepository.findById(asistencia.getIdTechnician())
                .map(tecnicoDTOConverter::build)
                .orElse(null);
        AssistanceDTO asistenciaDTO = dtoConverter.build(asistencia);
        asistenciaDTO.setTechnician(tecnicoDTO);
        return asistenciaDTO;
    }
}
