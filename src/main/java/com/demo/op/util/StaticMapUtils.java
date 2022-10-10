package com.demo.op.util;

import com.demo.op.data.entity.Asistencia;
import com.demo.op.data.entity.Reporte;
import com.demo.op.data.entity.Technician;
import com.demo.op.util.model.MapMarkerModel;
import com.demo.op.util.model.StaticMapModel;

import java.util.List;

public interface StaticMapUtils {
    String getMapUrl(StaticMapModel mapModel);

    StaticMapModel getStaticMapModel(Asistencia asistencia);

    StaticMapModel getStaticMapModel(Asistencia asistencia, List<Technician> tecnicos);

    StaticMapModel getStaticMapModel(List<Technician> tecnicos);

    StaticMapModel getStaticMapModel(Asistencia asistencia, Technician selectedTechnician);

    StaticMapModel getStaticMapModel(Technician selectedTechnician);

    StaticMapModel getStaticMapModel(Reporte reporte);

    StaticMapModel getStaticMapModel(Asistencia asistencia, List<Technician> tecnicos, Technician selectedTechnician);

    StaticMapModel getStaticMapModel(List<Reporte> reportes, Reporte selectedReporte);

    MapMarkerModel getMarker(Asistencia asistencia);

    MapMarkerModel getMarker(Technician tecnico);

    MapMarkerModel getMarker(Reporte reporte);

    MapMarkerModel getMarker(Technician tecnico, boolean selected);

    MapMarkerModel getMarker(Reporte reporte, boolean selected);

    StaticMapModel getMapModel(Reporte reporte);

    StaticMapModel getMapModel(Asistencia asistencia);

    StaticMapModel getMapModel(Technician tecnico);

    StaticMapModel getMapModel();
}
