package com.demo.op.rest;

import com.demo.op.api.TechnicianApi;
import com.demo.op.converter.DTOConverter;
import com.demo.op.data.TechnicianRepository;
import com.demo.op.data.entity.Technician;
import com.demo.op.model.*;
import com.demo.op.util.exception.NoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TechnicianRestController implements TechnicianApi {
    @Autowired
    private TechnicianRepository tecnicoRepository;
    @Autowired
    @Qualifier("TechnicianDTOConverter")
    private DTOConverter<TechnicianDTO, Technician> dtoConverter;

    @Override
    public ResponseEntity<TecniciansResponseDTO> getAllTechnicians() {
        List<TechnicianDTO> dtoList = tecnicoRepository.findAll()
                .stream().map(dtoConverter::build)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new TecniciansResponseDTO().value(dtoList));
    }

    @Override
    public ResponseEntity<TechnicianResponseDTO> getTechnicianById(Long id) {
        return tecnicoRepository.findById(id)
                .map(dtoConverter::build)
                .map(dto -> ResponseEntity.ok(new TechnicianResponseDTO().value(dto)))
                .orElseThrow(() -> new NoEncontradoException("Technician no encontrado"));
    }

    @Override
    public ResponseEntity<TechnicianResponseDTO> getTechnicianByTelefono(String telefono) {
        return tecnicoRepository.getTechnicianByTelefono(telefono)
                .map(dtoConverter::build)
                .map(dto -> ResponseEntity.ok(new TechnicianResponseDTO().value(dto)))
                .orElseThrow(() -> new NoEncontradoException("Technician no encontrado"));
    }

    @Override
    public ResponseEntity<TechnicianResponseDTO> saveTechnician(TechnicianRequestDTO tecnicoRequestDTO) {
        Technician tecnico = Technician.builder()
                .nombre(tecnicoRequestDTO.getNombre())
                .apellido(tecnicoRequestDTO.getApellido())
                .telefono(tecnicoRequestDTO.getTelefono())
                .latitud(tecnicoRequestDTO.getLatitud())
                .longitud(tecnicoRequestDTO.getLongitud())
                .build();
        tecnico = tecnicoRepository.save(tecnico);
        return ResponseEntity.ok(new TechnicianResponseDTO().value(dtoConverter.build(tecnico)));
    }

    @Override
    public ResponseEntity<EmptyResponseDTO> updateTechnician(Long id, TechnicianRequestDTO tecnicoRequestDTO) {
        return tecnicoRepository.findById(id)
                .map(tecnico -> {
                    tecnico.setNombre(tecnicoRequestDTO.getNombre());
                    tecnico.setApellido(tecnicoRequestDTO.getApellido());
                    tecnico.setTelefono(tecnicoRequestDTO.getTelefono());
                    tecnico.setLatitud(tecnicoRequestDTO.getLatitud());
                    tecnico.setLongitud(tecnicoRequestDTO.getLongitud());
                    tecnicoRepository.save(tecnico);
                    return ResponseEntity.ok(new EmptyResponseDTO().message("Actualizado con exito"));
                })
                .orElseThrow(() -> new NoEncontradoException("Technician no encontrado"));
    }

    @Override
    public ResponseEntity<EmptyResponseDTO> updateTechnicianLocation(Long id, LocationRequestDTO locationRequestDTO) {
        return tecnicoRepository.findById(id)
                .map(tecnico -> {
                    tecnico.setLatitud(locationRequestDTO.getLatitud());
                    tecnico.setLongitud(locationRequestDTO.getLongitud());
                    tecnicoRepository.save(tecnico);
                    return ResponseEntity.ok(new EmptyResponseDTO().message("Ubicacion actualizada con exito"));
                })
                .orElseThrow(() -> new NoEncontradoException("Technician no encontrado"));
    }
}
