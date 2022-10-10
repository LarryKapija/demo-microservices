package com.demo.op.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;

/**
 * EstadoReporteDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-21T09:36:06.188-04:00[America/Santo_Domingo]")
public class EstadoReporteDTO   {

  @JsonProperty("descripcion")
  private String descripcion;

  @JsonProperty("descripcionSecundaria")
  private String descripcionSecundaria;

  @JsonProperty("porcentajeCompletado")
  private Float porcentajeCompletado;

  @JsonProperty("color")
  private String color;

  @JsonProperty("detalle")
  @Valid
  private List<ReportStateDetailDTO> detalle = null;

  public EstadoReporteDTO descripcion(String descripcion) {
    this.descripcion = descripcion;
    return this;
  }

  /**
   * Get descripcion
   * @return descripcion
  */
  @Size(max = 50) 
  @Schema(name = "descripcion", required = false)
  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public EstadoReporteDTO descripcionSecundaria(String descripcionSecundaria) {
    this.descripcionSecundaria = descripcionSecundaria;
    return this;
  }

  /**
   * Get descripcionSecundaria
   * @return descripcionSecundaria
  */
  @Size(max = 50) 
  @Schema(name = "descripcionSecundaria", required = false)
  public String getDescripcionSecundaria() {
    return descripcionSecundaria;
  }

  public void setDescripcionSecundaria(String descripcionSecundaria) {
    this.descripcionSecundaria = descripcionSecundaria;
  }

  public EstadoReporteDTO porcentajeCompletado(Float porcentajeCompletado) {
    this.porcentajeCompletado = porcentajeCompletado;
    return this;
  }

  /**
   * Get porcentajeCompletado
   * @return porcentajeCompletado
  */
  
  @Schema(name = "porcentajeCompletado", required = false)
  public Float getPorcentajeCompletado() {
    return porcentajeCompletado;
  }

  public void setPorcentajeCompletado(Float porcentajeCompletado) {
    this.porcentajeCompletado = porcentajeCompletado;
  }

  public EstadoReporteDTO color(String color) {
    this.color = color;
    return this;
  }

  /**
   * Get color
   * @return color
  */
  
  @Schema(name = "color", required = false)
  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public EstadoReporteDTO detalle(List<ReportStateDetailDTO> detalle) {
    this.detalle = detalle;
    return this;
  }

  public EstadoReporteDTO addDetalleItem(ReportStateDetailDTO detalleItem) {
    if (this.detalle == null) {
      this.detalle = new ArrayList<>();
    }
    this.detalle.add(detalleItem);
    return this;
  }

  /**
   * Get detalle
   * @return detalle
  */
  @Valid 
  @Schema(name = "detalle", required = false)
  public List<ReportStateDetailDTO> getDetalle() {
    return detalle;
  }

  public void setDetalle(List<ReportStateDetailDTO> detalle) {
    this.detalle = detalle;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EstadoReporteDTO estadoReporte = (EstadoReporteDTO) o;
    return Objects.equals(this.descripcion, estadoReporte.descripcion) &&
        Objects.equals(this.descripcionSecundaria, estadoReporte.descripcionSecundaria) &&
        Objects.equals(this.porcentajeCompletado, estadoReporte.porcentajeCompletado) &&
        Objects.equals(this.color, estadoReporte.color) &&
        Objects.equals(this.detalle, estadoReporte.detalle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(descripcion, descripcionSecundaria, porcentajeCompletado, color, detalle);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EstadoReporteDTO {\n");
    sb.append("    descripcion: ").append(toIndentedString(descripcion)).append("\n");
    sb.append("    descripcionSecundaria: ").append(toIndentedString(descripcionSecundaria)).append("\n");
    sb.append("    porcentajeCompletado: ").append(toIndentedString(porcentajeCompletado)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    detalle: ").append(toIndentedString(detalle)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

