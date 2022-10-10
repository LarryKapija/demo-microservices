package com.demo.op.controller;

import com.demo.op.data.EstadoReporteRepository;
import com.demo.op.data.FotoReporteRepository;
import com.demo.op.data.entity.Reporte;
import com.demo.op.service.ProyectoService;
import com.demo.op.service.ReporteService;
import com.demo.op.util.StaticMapUtils;
import com.demo.op.util.StringUtils;
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

import static com.demo.op.util.model.EstadoReporteEnum.ENVIADO;

@Controller
public class ReporteController {

    @Autowired
    ReporteService reporteService;
    @Autowired
    ProyectoService proyectoService;
    @Autowired
    FotoReporteRepository fotoReporteRepository;
    @Autowired
    EstadoReporteRepository estadoReporteRepository;
    @Autowired
    StaticMapUtils staticMapUtils;

    @GetMapping("/admin/crear-reporte")
    public String showAddReporte(Model model) {
        model.addAttribute("reporte", new Reporte());
        model.addAttribute("proyectos", proyectoService.getAllActive());
        return "nuevo-reporte";
    }

    @PostMapping("/admin/addReporte")
    public String addReporte(@Valid Reporte reporte, BindingResult result, Model model) {
        if(result.hasErrors())
            return "nuevo-reporte";

        estadoReporteRepository.getEstadoByDescripcion(ENVIADO.getValue())
                        .ifPresent(reporte::setEstado);
        reporte.setTelefono(StringUtils.cleanPhoneNumber(reporte.getTelefono()));
        Reporte newReporte = reporteService.save(reporte);

        if(newReporte.getIdProyecto()!=null)
            reporteService.update(newReporte);

        return "redirect:/admin/reportes";
    }

    @GetMapping("/admin/reportes")
    public String showReportes(Model model) {
        List<Reporte> reportes = reporteService.getAllActive();
        Reporte selectedReporte = null;
        StaticMapModel mapModel = staticMapUtils.getStaticMapModel(reportes, selectedReporte);
        mapModel.setZoom(10);
        model.addAttribute("reportes", reportes);
        model.addAttribute("selectedReporte", selectedReporte);
        model.addAttribute("mapUrl",
                staticMapUtils.getMapUrl(mapModel));
        return "reportes";
    }

    @GetMapping("/admin/edit-reporte/{id}")
    public String showUpdateReporteForm(@PathVariable("id") long id, Model model) {
        Reporte reporte = reporteService.findById(id)
                .orElseThrow(() -> new RequestInvalidoException("Id de reporte invalido: " + id));
        StaticMapModel mapModel = staticMapUtils.getStaticMapModel(reporte);
        model.addAttribute("reporte", reporte);
        model.addAttribute("proyectos", proyectoService.getAllActive());
        model.addAttribute("fotos", fotoReporteRepository.findByIdReporte(id));
        model.addAttribute("mapUrl",
                staticMapUtils.getMapUrl(mapModel));
        return  "modificar-reporte";
    }

    @PostMapping("/admin/update-reporte/{id}")
    public String updateReporte(@PathVariable("id") long id, @Valid Reporte reporte,
                                BindingResult result, Model model) {
        if(result.hasErrors()) {
            reporte.setId(id);
            return "modificar-reporte";
        }

        reporteService.findById(id)
                .ifPresent((reporteUpd) -> {
                    reporteUpd.setIdProyecto(reporte.getIdProyecto());
                    reporteService.update(reporteUpd);
                });

        return "redirect:/admin/reportes";
    }
}
