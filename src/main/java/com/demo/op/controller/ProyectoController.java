package com.demo.op.controller;

import com.demo.op.data.entity.Proyecto;
import com.demo.op.service.ProyectoService;
import com.demo.op.service.ReporteService;
import com.demo.op.util.exception.RequestInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.OffsetDateTime;

@Controller
public class ProyectoController {

    @Autowired
    ProyectoService proyectoService;
    @Autowired
    ReporteService reporteService;

    @GetMapping("/admin/crear-proyecto")
    public String showAddProyecto(Model model) {
        model.addAttribute("proyecto", new Proyecto());
        return "nuevo-proyecto";
    }

    @PostMapping("/admin/addProyecto")
    public String addProyecto(@Valid Proyecto proyecto, BindingResult result, Model model) {
        if(result.hasErrors())
            return "nuevo-proyecto";

        proyecto.setEstado(Proyecto.DEFAULT_STATUS);
        proyecto.setFechaCreacion(OffsetDateTime.now());
        proyectoService.save(proyecto);
        return "redirect:/admin/proyectos";
    }

    @GetMapping("/admin/proyectos")
    public String showProyectos(Model model) {
        model.addAttribute("proyectos", proyectoService.getAllActive());
        return "proyectos";
    }

    @GetMapping("/admin/edit-proyecto/{id}")
    public String showProyectoForm(@PathVariable("id") long id, Model model) {
        Proyecto proyecto = proyectoService.findById(id)
                .orElseThrow(() -> new RequestInvalidoException("Id de proyecto invalido: " + id));
        model.addAttribute("reportes", reporteService.getReportesByProyecto(proyecto.getId()));
        model.addAttribute("proyecto", proyecto);
        return  "modificar-proyecto";
    }

    @PostMapping("/admin/update-proyecto/{id}")
    public String updateProyecto(@PathVariable("id") long id, @Valid Proyecto proyecto,
                                   BindingResult result, Model model) {
        if(result.hasErrors()) {
            proyecto.setId(id);
            return "modificar-proyecto";
        }

        proyectoService.findById(id)
                .ifPresent((proyectoUpd) -> {
                    proyectoUpd.setDescripcion(proyecto.getDescripcion());
                    proyectoUpd.setNotas(proyecto.getNotas());
                    proyectoUpd.setEstimadoEnMeses(proyecto.getEstimadoEnMeses());
                    proyectoUpd.setEncargado(proyecto.getEncargado());
                    proyectoUpd.setEstado(proyecto.getEstado());
                    proyectoService.update(proyectoUpd);
                });

        return "redirect:/admin/proyectos";
    }
}
