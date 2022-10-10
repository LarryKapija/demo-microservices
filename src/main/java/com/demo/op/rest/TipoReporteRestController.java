package com.demo.op.rest;

import com.demo.op.api.TipoReporteApi;
import com.demo.op.converter.DTOConverter;
import com.demo.op.data.TipoReporteRepository;
import com.demo.op.data.entity.TipoRepote;
import com.demo.op.model.ReportsTypesDTO;
import com.demo.op.model.ReportsTypesResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TipoReporteRestController implements TipoReporteApi {

    @Autowired
    private TipoReporteRepository tipoReporteRepository;

    @Autowired
    @Qualifier("TipoReporteDTOConverter")
    private DTOConverter<ReportsTypesDTO, TipoRepote> dtoConverter;

    @Override
    public ResponseEntity<ReportsTypesResponseDTO> getAllTipoReporte() {
        List<ReportsTypesDTO> dtoList = tipoReporteRepository.findAll()
                .stream().map(dtoConverter::build)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new ReportsTypesResponseDTO().value(dtoList));
    }
}
