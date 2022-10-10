package com.demo.op.util.gmaps;

import com.demo.op.data.entity.Asistencia;
import com.demo.op.data.entity.Reporte;
import com.demo.op.data.entity.Technician;
import com.demo.op.util.StaticMapUtils;
import com.demo.op.util.model.MapMarkerModel;
import com.demo.op.util.model.MarkerColor;
import com.demo.op.util.model.MarkerSize;
import com.demo.op.util.model.StaticMapModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StaticMapUtilsImpl implements StaticMapUtils {

    @Value("${staticMapURL}")
    String staticMapURL;

    @Value("${googleMapsApiKey}")
    String googleMapsApiKey;

    public String getMapUrl(StaticMapModel mapModel) {
        StringBuilder mapUrlBuilder = new StringBuilder(staticMapURL
                +"?center="+mapModel.getLatitud()+",+"+mapModel.getLongitud()
                +"&zoom="+mapModel.getZoom()
                +"&scale="+mapModel.isScale()
                +"&size="+mapModel.getWidth()+"x"+mapModel.getHeight()
                +"&maptype="+mapModel.getMapType() +
                "&key="+googleMapsApiKey
                +"&format="+mapModel.getFormat()
                +"&visual_refresh="+mapModel.isVisualRefresh());

        mapModel.getMarkers().forEach(marker ->
            mapUrlBuilder.append("&markers=size:"+marker.getSize()
                    +"%7Ccolor:"+marker.getColor()
                    +"%7Clabel:"+marker.getLabel()+"%7C" +
                    marker.getLatitud()+ ",+" +
                    marker.getLongitud())
        );
        return mapUrlBuilder.toString();
    }

    public StaticMapModel getStaticMapModel(Asistencia asistencia) {
        return  getStaticMapModel(asistencia, null, null);
    }

    public StaticMapModel getStaticMapModel(Asistencia asistencia, List<Technician> tecnicos) {
        return getStaticMapModel(asistencia, tecnicos, null);
    }

    public StaticMapModel getStaticMapModel(List<Technician> tecnicos) {
        return getStaticMapModel(null, tecnicos, null);
    }

    public StaticMapModel getStaticMapModel(Asistencia asistencia, Technician selectedTechnician) {
        return getStaticMapModel(asistencia, null, selectedTechnician);
    }

    public StaticMapModel getStaticMapModel(Technician selectedTechnician) {
        return getStaticMapModel(null, null, selectedTechnician);
    }

    public StaticMapModel getStaticMapModel(Reporte reporte) {
        return getStaticMapModel(null, reporte);
    }

    public StaticMapModel getStaticMapModel(Asistencia asistencia, List<Technician> tecnicos, Technician selectedTechnician) {
        StaticMapModel mapModel;
        if(asistencia!=null)
            mapModel = getMapModel(asistencia);
        else if(selectedTechnician!=null)
            mapModel = getMapModel(selectedTechnician);
        else if(tecnicos.size()>0)
            mapModel = getMapModel(tecnicos.get(0));
        else
            mapModel = getMapModel();

        if(asistencia!=null)
            mapModel.getMarkers().add(getMarker(asistencia));
        if(tecnicos!=null)
            mapModel.getMarkers().addAll(tecnicos.stream()
                            .filter(tecnico -> selectedTechnician==null || tecnico.getId() != selectedTechnician.getId())
                    .map(this::getMarker)
                    .collect(Collectors.toList()));
        if(selectedTechnician!=null)
            mapModel.getMarkers().add(getMarker(selectedTechnician, true));
        return mapModel;
    }

    public StaticMapModel getStaticMapModel(List<Reporte> reportes, Reporte selectedReporte) {
        StaticMapModel mapModel;
        if(selectedReporte!=null)
            mapModel = getMapModel(selectedReporte);
        else if(reportes.size()>0)
            mapModel = getMapModel(reportes.get(0));
        else
            mapModel = getMapModel();

        if(reportes!=null)
            mapModel.getMarkers().addAll(reportes.stream()
                    .filter(tecnico -> selectedReporte==null || tecnico.getId() != selectedReporte.getId())
                    .map(this::getMarker)
                    .collect(Collectors.toList()));
        if(selectedReporte!=null)
            mapModel.getMarkers().add(getMarker(selectedReporte, true));
        return mapModel;
    }

    public MapMarkerModel getMarker(Asistencia asistencia) {
        return MapMarkerModel.builder()
                .label("C")
                .color(MarkerColor.RED)
                .latitud(asistencia.getLatitud())
                .longitud(asistencia.getLongitud())
                .build();
    }

    public MapMarkerModel getMarker(Technician tecnico) {
        return getMarker(tecnico, false);
    }

    public MapMarkerModel getMarker(Reporte reporte) {
        return getMarker(reporte, false);
    }

    public MapMarkerModel getMarker(Technician tecnico, boolean selected) {
        return MapMarkerModel.builder()
                .label("T")
                .color(selected ? MarkerColor.BLUE : MarkerColor.LIGHT_GRAY)
                .size(MarkerSize.LARGE)
                .latitud(tecnico.getLatitud())
                .longitud(tecnico.getLongitud())
                .build();
    }

    public MapMarkerModel getMarker(Reporte reporte, boolean selected) {
        return MapMarkerModel.builder()
                .label("R")
                .color(selected ? MarkerColor.BLUE : MarkerColor.RED)
                .size(MarkerSize.LARGE)
                .latitud(reporte.getLatitud())
                .longitud(reporte.getLongitud())
                .build();
    }

    public StaticMapModel getMapModel(Reporte reporte) {
        return StaticMapModel.builder()
                .latitud(reporte.getLatitud())
                .longitud(reporte.getLongitud())
                .build();
    }

    public StaticMapModel getMapModel(Asistencia asistencia) {
        return StaticMapModel.builder()
                .latitud(asistencia.getLatitud())
                .longitud(asistencia.getLongitud())
                .build();
    }

    public StaticMapModel getMapModel(Technician tecnico) {
        return StaticMapModel.builder()
                .latitud(tecnico.getLatitud())
                .longitud(tecnico.getLongitud())
                .build();
    }

    public StaticMapModel getMapModel() {
        return StaticMapModel.builder()
                .build();
    }
}
