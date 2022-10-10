package com.demo.op.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import javax.annotation.Generated;

/**
 * DetalleEstadoReporteDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-21T09:36:06.188-04:00[America/Santo_Domingo]")
public class ReportStateDetailDTO   {

  @JsonProperty("nombre")
  private String nombre;

  @JsonProperty("fechaInicio")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime fechaInicio;

  @JsonProperty("fechaFinal")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime fechaFinal;

  public ReportStateDetailDTO nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Get nombre
   * @return nombre
  */
  @Size(max = 50) 
  @Schema(name = "nombre", required = false)
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public ReportStateDetailDTO fechaInicio(OffsetDateTime fechaInicio) {
    this.fechaInicio = fechaInicio;
    return this;
  }

  /**
   * Get fechaInicio
   * @return fechaInicio
  */
  @Valid 
  @Schema(name = "fechaInicio", required = false)
  public OffsetDateTime getFechaInicio() {
    return fechaInicio;
  }

  public void setFechaInicio(OffsetDateTime fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  public ReportStateDetailDTO fechaFinal(OffsetDateTime fechaFinal) {
    this.fechaFinal = fechaFinal;
    return this;
  }

  /**
   * Get fechaFinal
   * @return fechaFinal
  */
  @Valid 
  @Schema(name = "fechaFinal", required = false)
  public OffsetDateTime getFechaFinal() {
    return fechaFinal;
  }

  public void setFechaFinal(OffsetDateTime fechaFinal) {
    this.fechaFinal = fechaFinal;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReportStateDetailDTO detalleEstadoReporte = (ReportStateDetailDTO) o;
    return Objects.equals(this.nombre, detalleEstadoReporte.nombre) &&
        Objects.equals(this.fechaInicio, detalleEstadoReporte.fechaInicio) &&
        Objects.equals(this.fechaFinal, detalleEstadoReporte.fechaFinal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombre, fechaInicio, fechaFinal);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DetalleEstadoReporteDTO {\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    fechaInicio: ").append(toIndentedString(fechaInicio)).append("\n");
    sb.append("    fechaFinal: ").append(toIndentedString(fechaFinal)).append("\n");
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

