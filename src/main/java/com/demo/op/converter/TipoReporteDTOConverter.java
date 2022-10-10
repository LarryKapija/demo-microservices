package com.demo.op.converter;

import com.demo.op.data.entity.TipoRepote;
import com.demo.op.model.ReportsTypesDTO;
import org.springframework.stereotype.Component;

@Component("TipoReporteDTOConverter")
public class TipoReporteDTOConverter implements DTOConverter<ReportsTypesDTO, TipoRepote> {
    @Override
    public ReportsTypesDTO build(TipoRepote entity) {
        return new ReportsTypesDTO()
                .descripcion(entity.getDescripcion());
    }
}
