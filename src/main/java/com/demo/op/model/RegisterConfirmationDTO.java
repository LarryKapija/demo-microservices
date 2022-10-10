package com.demo.op.model;

import java.util.Objects;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * ConfirmacionRegistroDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-21T09:36:06.188-04:00[America/Santo_Domingo]")
public class RegisterConfirmationDTO   {

  @JsonProperty("solicitud")
  private String solicitud;

  public RegisterConfirmationDTO solicitud(String solicitud) {
    this.solicitud = solicitud;
    return this;
  }

  /**
   * Get solicitud
   * @return solicitud
  */
  
  @Schema(name = "solicitud", required = false)
  public String getSolicitud() {
    return solicitud;
  }

  public void setSolicitud(String solicitud) {
    this.solicitud = solicitud;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegisterConfirmationDTO confirmacionRegistro = (RegisterConfirmationDTO) o;
    return Objects.equals(this.solicitud, confirmacionRegistro.solicitud);
  }

  @Override
  public int hashCode() {
    return Objects.hash(solicitud);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConfirmacionRegistroDTO {\n");
    sb.append("    solicitud: ").append(toIndentedString(solicitud)).append("\n");
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

