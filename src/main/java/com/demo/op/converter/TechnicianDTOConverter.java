package com.demo.op.converter;

import com.demo.op.data.entity.Technician;
import com.demo.op.model.TechnicianDTO;
import org.springframework.stereotype.Component;

@Component("TechnicianDTOConverter")
public class TechnicianDTOConverter implements DTOConverter<TechnicianDTO, Technician> {
    @Override
    public TechnicianDTO build(Technician entity) {
        return new TechnicianDTO()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .apellido(entity.getApellido())
                .telefono(entity.getTelefono())
                .latitud(entity.getLatitud())
                .longitud(entity.getLongitud());
    }
}
