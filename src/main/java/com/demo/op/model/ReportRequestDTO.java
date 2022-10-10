package com.demo.op.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import javax.annotation.Generated;

/**
 * ReporteRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-21T09:36:06.188-04:00[America/Santo_Domingo]")
public class ReportRequestDTO   {

  @JsonProperty("telefono")
  private String telefono;

  @JsonProperty("descripcion")
  private String descripcion;

  /**
   * Gets or Sets tipoReporte
   */
  public enum TipoReporteEnum {
    HOYO_EN_PAVIMENTO("Hoyo en Pavimento"),
    
    OTRO("Otro");

    private String value;

    TipoReporteEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TipoReporteEnum fromValue(String value) {
      for (TipoReporteEnum b : TipoReporteEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("tipoReporte")
  private TipoReporteEnum tipoReporte;

  @JsonProperty("longitud")
  private String longitud;

  @JsonProperty("latitud")
  private String latitud;

  @JsonProperty("notas")
  private String notas;

  @JsonProperty("fotos")
  @Valid
  private List<String> fotos = null;

  public ReportRequestDTO telefono(String telefono) {
    this.telefono = telefono;
    return this;
  }

  /**
   * Get telefono
   * @return telefono
  */
  @NotNull 
  @Schema(name = "telefono", required = true)
  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public ReportRequestDTO descripcion(String descripcion) {
    this.descripcion = descripcion;
    return this;
  }

  /**
   * Get descripcion
   * @return descripcion
  */
  @NotNull 
  @Schema(name = "descripcion", required = true)
  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public ReportRequestDTO tipoReporte(TipoReporteEnum tipoReporte) {
    this.tipoReporte = tipoReporte;
    return this;
  }

  /**
   * Get tipoReporte
   * @return tipoReporte
  */
  
  @Schema(name = "tipoReporte", required = false)
  public TipoReporteEnum getTipoReporte() {
    return tipoReporte;
  }

  public void setTipoReporte(TipoReporteEnum tipoReporte) {
    this.tipoReporte = tipoReporte;
  }

  public ReportRequestDTO longitud(String longitud) {
    this.longitud = longitud;
    return this;
  }

  /**
   * Get longitud
   * @return longitud
  */
  @NotNull 
  @Schema(name = "longitud", required = true)
  public String getLongitud() {
    return longitud;
  }

  public void setLongitud(String longitud) {
    this.longitud = longitud;
  }

  public ReportRequestDTO latitud(String latitud) {
    this.latitud = latitud;
    return this;
  }

  /**
   * Get latitud
   * @return latitud
  */
  @NotNull 
  @Schema(name = "latitud", required = true)
  public String getLatitud() {
    return latitud;
  }

  public void setLatitud(String latitud) {
    this.latitud = latitud;
  }

  public ReportRequestDTO notas(String notas) {
    this.notas = notas;
    return this;
  }

  /**
   * Get notas
   * @return notas
  */
  
  @Schema(name = "notas", required = false)
  public String getNotas() {
    return notas;
  }

  public void setNotas(String notas) {
    this.notas = notas;
  }

  public ReportRequestDTO fotos(List<String> fotos) {
    this.fotos = fotos;
    return this;
  }

  public ReportRequestDTO addFotosItem(String fotosItem) {
    if (this.fotos == null) {
      this.fotos = new ArrayList<>();
    }
    this.fotos.add(fotosItem);
    return this;
  }

  /**
   * Get fotos
   * @return fotos
  */
  
  @Schema(name = "fotos", required = false)
  public List<String> getFotos() {
    return fotos;
  }

  public void setFotos(List<String> fotos) {
    this.fotos = fotos;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReportRequestDTO reporteRequest = (ReportRequestDTO) o;
    return Objects.equals(this.telefono, reporteRequest.telefono) &&
        Objects.equals(this.descripcion, reporteRequest.descripcion) &&
        Objects.equals(this.tipoReporte, reporteRequest.tipoReporte) &&
        Objects.equals(this.longitud, reporteRequest.longitud) &&
        Objects.equals(this.latitud, reporteRequest.latitud) &&
        Objects.equals(this.notas, reporteRequest.notas) &&
        Objects.equals(this.fotos, reporteRequest.fotos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(telefono, descripcion, tipoReporte, longitud, latitud, notas, fotos);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReporteRequestDTO {\n");
    sb.append("    telefono: ").append(toIndentedString(telefono)).append("\n");
    sb.append("    descripcion: ").append(toIndentedString(descripcion)).append("\n");
    sb.append("    tipoReporte: ").append(toIndentedString(tipoReporte)).append("\n");
    sb.append("    longitud: ").append(toIndentedString(longitud)).append("\n");
    sb.append("    latitud: ").append(toIndentedString(latitud)).append("\n");
    sb.append("    notas: ").append(toIndentedString(notas)).append("\n");
    sb.append("    fotos: ").append(toIndentedString(fotos)).append("\n");
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

