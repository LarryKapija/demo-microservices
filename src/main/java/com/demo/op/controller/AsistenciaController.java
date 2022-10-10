package com.demo.op.controller;

import java.time.OffsetDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.op.data.TechnicianRepository;
import com.demo.op.data.entity.Asistencia;
import com.demo.op.data.entity.Technician;
import com.demo.op.model.AssistanceDTO;
import com.demo.op.service.AsistenciaService;
import com.demo.op.util.StaticMapUtils;
import com.demo.op.util.StringUtils;
import com.demo.op.util.exception.RequestInvalidoException;
import com.demo.op.util.model.StaticMapModel;

@Controller
public class AsistenciaController {

    @Autowired
    AsistenciaService asistenciaService;
    @Autowired
    TechnicianRepository tecnicoRepository;
    @Autowired
    StaticMapUtils staticMapUtils;

    @GetMapping("/admin/crear-asistencia")
    public String showAddAsistencia(Model model) {
        model.addAttribute("asistencia", new Asistencia());
        model.addAttribute("tecnicos", tecnicoRepository.getAllTechniciansSinAsignar());
        return "nueva-asistencia";
    }

    @PostMapping("/admin/addAsistencia")
    public String addAsistencia(@Valid Asistencia asistencia, BindingResult result, Model model) {
        if(result.hasErrors())
            return "nueva-asistencia";

        asistencia.setEstado(AssistanceDTO.EstadoEnum.ENVIADA.getValue());
        asistencia.setFechaLlamada(OffsetDateTime.now());
        asistencia.setTelefono(StringUtils.cleanPhoneNumber(asistencia.getTelefono()));
        asistenciaService.save(asistencia);

        return "redirect:/admin/asistencias";
    }

    @GetMapping("/admin/asistencias")
    public String showAsistencias(Model model) {
        model.addAttribute("asistencias", asistenciaService.getAllActive());
        return "index";
    }

    @GetMapping("/admin/edit-asistencia/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Asistencia asistencia = asistenciaService.findById(id)
                .orElseThrow(() -> new RequestInvalidoException("Id de asistencia invalido: " + id));
        Technician tecnicoAsignado = null;
        if(asistencia.getIdTechnician()!=null)
            tecnicoAsignado = tecnicoRepository.findById(asistencia.getIdTechnician()).orElse(null);
        List<Technician> tecnicosSinAsignar  = tecnicoRepository.getAllTechniciansSinAsignar(asistencia.getIdTechnician());

        StaticMapModel mapModel = staticMapUtils.getStaticMapModel(asistencia, tecnicosSinAsignar, tecnicoAsignado);

        model.addAttribute("urlImagenFirma", asistencia.getUrlImagenFirma());
        model.addAttribute("asistencia", asistencia);
        model.addAttribute("tecnicos", tecnicosSinAsignar);
        model.addAttribute("mapUrl",
                staticMapUtils.getMapUrl(mapModel));
        return  "modificar-asistencia";
    }

    @PostMapping("/admin/update-asistencia/{id}")
    public String updateAsistencia(@PathVariable("id") long id, @Valid Asistencia asistencia,
                                   BindingResult result, Model model) {
        if(result.hasErrors()) {
            asistencia.setId(id);
            return "modificar-asistencia";
        }
        asistencia.setTelefono(StringUtils.cleanPhoneNumber(asistencia.getTelefono()));
        asistenciaService.findById(id)
                        .ifPresent((asistenciaUpd) -> {
                            asistenciaUpd.setNombre(asistencia.getNombre());
                            asistenciaUpd.setApellido(asistencia.getApellido());
                            asistenciaUpd.setTelefono(asistencia.getTelefono());
                            asistenciaUpd.setTipoSituacion(asistencia.getTipoSituacion());
                            asistenciaUpd.setPlaca(asistencia.getPlaca());
                            asistenciaUpd.setIdTechnician(asistencia.getIdTechnician());
                            asistenciaUpd.setEstado(asistencia.getEstado());
                            asistenciaService.update(asistenciaUpd);
                        });

        return "redirect:/admin/asistencias";
    }
}
