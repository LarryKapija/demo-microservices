package com.demo.op.controller;

import com.demo.op.data.TechnicianRepository;
import com.demo.op.data.entity.Technician;
import com.demo.op.util.StaticMapUtils;
import com.demo.op.util.exception.RequestInvalidoException;
import com.demo.op.util.model.StaticMapModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TechnicianController {

    @Autowired
    TechnicianRepository tecnicoRepository;

    @Autowired
    StaticMapUtils staticMapUtils;

    @GetMapping("/admin/crear-tecnico")
    public String showAddTechnician(Technician tecnico) {
        return "nuevo-tecnico";
    }

    @PostMapping("/admin/addTechnician")
    public String addTechnician(@Valid Technician tecnico, BindingResult result, Model model) {
        if(result.hasErrors())
            return "nuevo-tecnico";

        tecnicoRepository.save(tecnico);
        return "redirect:/admin/tecnicos";
    }

    @GetMapping("/admin/tecnicos")
    public String showTechnicians(Model model) {
        List<Technician> tecnicos = tecnicoRepository.findAll();
        StaticMapModel mapModel = staticMapUtils.getStaticMapModel(tecnicos);
        mapModel.setZoom(10);
        model.addAttribute("tecnicos", tecnicos);
        model.addAttribute("mapUrl",
                staticMapUtils.getMapUrl(mapModel));
        return "tecnicos";
    }

    @GetMapping("/admin/edit-tecnico/{id}")
    public String showUpdateTechnicianForm(@PathVariable("id") long id, Model model) {
        Technician tecnico = tecnicoRepository.findById(id)
                .orElseThrow(() -> new RequestInvalidoException("Id de tecnico invalido: " + id));
        StaticMapModel mapModel = staticMapUtils.getStaticMapModel(tecnico);
        model.addAttribute("tecnico", tecnico);
        model.addAttribute("mapUrl",
                staticMapUtils.getMapUrl(mapModel));
        return  "modificar-tecnico";
    }

    @PostMapping("/admin/update-tecnico/{id}")
    public String updateTechnician(@PathVariable("id") long id, @Valid Technician tecnico,
                                   BindingResult result, Model model) {
        if(result.hasErrors()) {
            tecnico.setId(id);
            return "modificar-tecnico";
        }

        tecnicoRepository.findById(id)
                .ifPresent((tecnicoUpd) -> {
                    tecnicoUpd.setNombre(tecnico.getNombre());
                    tecnicoUpd.setApellido(tecnico.getApellido());
                    tecnicoUpd.setTelefono(tecnico.getTelefono());
                    tecnicoRepository.save(tecnicoUpd);
                });

        return "redirect:/admin/tecnicos";
    }
}
