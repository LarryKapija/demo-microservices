package com.demo.op.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import javax.annotation.Generated;

/**
 * EstadoAsistenciaRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-21T09:36:06.188-04:00[America/Santo_Domingo]")
public class AssistanceStatusRequestDTO   {

  @JsonProperty("notasTechnician")
  private String notasTechnician;

  @JsonProperty("urlImagenFirma")
  private String urlImagenFirma;

  /**
   * Estado de la asistencia
   */
  public enum EstadoEnum {
    ENVIADA("Enviada"),
    
    ASIGNADA("Asignada"),
    
    EN_PROCESO("En Proceso"),
    
    COMPLETADA("Completada"),
    
    CERRADA("Cerrada");

    private String value;

    EstadoEnum(String value) {
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
    public static EstadoEnum fromValue(String value) {
      for (EstadoEnum b : EstadoEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("estado")
  private EstadoEnum estado;

  public AssistanceStatusRequestDTO notasTechnician(String notasTechnician) {
    this.notasTechnician = notasTechnician;
    return this;
  }

  /**
   * Get notasTechnician
   * @return notasTechnician
  */
  @NotNull @Size(max = 2000) 
  @Schema(name = "notasTechnician", required = true)
  public String getNotasTechnician() {
    return notasTechnician;
  }

  public void setNotasTechnician(String notasTechnician) {
    this.notasTechnician = notasTechnician;
  }

  public AssistanceStatusRequestDTO urlImagenFirma(String urlImagenFirma) {
    this.urlImagenFirma = urlImagenFirma;
    return this;
  }

  /**
   * Get urlImagenFirma
   * @return urlImagenFirma
  */
  @Size(max = 250) 
  @Schema(name = "urlImagenFirma", required = false)
  public String getUrlImagenFirma() {
    return urlImagenFirma;
  }

  public void setUrlImagenFirma(String urlImagenFirma) {
    this.urlImagenFirma = urlImagenFirma;
  }

  public AssistanceStatusRequestDTO estado(EstadoEnum estado) {
    this.estado = estado;
    return this;
  }

  /**
   * Estado de la asistencia
   * @return estado
  */
  @NotNull 
  @Schema(name = "estado", description = "Estado de la asistencia", required = true)
  public EstadoEnum getEstado() {
    return estado;
  }

  public void setEstado(EstadoEnum estado) {
    this.estado = estado;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssistanceStatusRequestDTO estadoAsistenciaRequest = (AssistanceStatusRequestDTO) o;
    return Objects.equals(this.notasTechnician, estadoAsistenciaRequest.notasTechnician) &&
        Objects.equals(this.urlImagenFirma, estadoAsistenciaRequest.urlImagenFirma) &&
        Objects.equals(this.estado, estadoAsistenciaRequest.estado);
  }

  @Override
  public int hashCode() {
    return Objects.hash(notasTechnician, urlImagenFirma, estado);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EstadoAsistenciaRequestDTO {\n");
    sb.append("    notasTechnician: ").append(toIndentedString(notasTechnician)).append("\n");
    sb.append("    urlImagenFirma: ").append(toIndentedString(urlImagenFirma)).append("\n");
    sb.append("    estado: ").append(toIndentedString(estado)).append("\n");
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

