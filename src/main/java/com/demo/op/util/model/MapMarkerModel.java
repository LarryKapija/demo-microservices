package com.demo.op.util.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MapMarkerModel {
    @Builder.Default
    private MarkerSize size = MarkerSize.LARGE;
    @Builder.Default
    private MarkerColor color = MarkerColor.RED;
    private String label;
    private String latitud;
    private String longitud;
}
