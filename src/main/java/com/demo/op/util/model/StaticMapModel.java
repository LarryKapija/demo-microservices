package com.demo.op.util.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StaticMapModel {

    @Builder.Default
    private int zoom = 18;
    private boolean scale;
    @Builder.Default
    private int width = 600;
    @Builder.Default
    private int height = 300;
    @Builder.Default
    private MapType mapType = MapType.ROADMAP;
    private String latitud;
    private String longitud;
    @Builder.Default
    private String format = "png";
    @Builder.Default
    private boolean visualRefresh = true;
    @Builder.Default
    List<MapMarkerModel> markers = new ArrayList<>();


}
