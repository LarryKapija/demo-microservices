package com.demo.op.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;


import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

/**
 * ConfirmacionRegistroRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-21T09:36:06.188-04:00[America/Santo_Domingo]")
public class RegisterConfirmationRequestDTO   {

  @JsonProperty("solicitud")
  private String solicitud;

  @JsonProperty("oneTimePassword")
  private String oneTimePassword;

  public RegisterConfirmationRequestDTO solicitud(String solicitud) {
    this.solicitud = solicitud;
    return this;
  }

  /**
   * Get solicitud
   * @return solicitud
  */
  @NotNull 
  @Schema(name = "solicitud", required = true)
  public String getSolicitud() {
    return solicitud;
  }

  public void setSolicitud(String solicitud) {
    this.solicitud = solicitud;
  }

  public RegisterConfirmationRequestDTO oneTimePassword(String oneTimePassword) {
    this.oneTimePassword = oneTimePassword;
    return this;
  }

  /**
   * Get oneTimePassword
   * @return oneTimePassword
  */
  @NotNull 
  @Schema(name = "oneTimePassword", required = true)
  public String getOneTimePassword() {
    return oneTimePassword;
  }

  public void setOneTimePassword(String oneTimePassword) {
    this.oneTimePassword = oneTimePassword;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegisterConfirmationRequestDTO confirmacionRegistroRequest = (RegisterConfirmationRequestDTO) o;
    return Objects.equals(this.solicitud, confirmacionRegistroRequest.solicitud) &&
        Objects.equals(this.oneTimePassword, confirmacionRegistroRequest.oneTimePassword);
  }

  @Override
  public int hashCode() {
    return Objects.hash(solicitud, oneTimePassword);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConfirmacionRegistroRequestDTO {\n");
    sb.append("    solicitud: ").append(toIndentedString(solicitud)).append("\n");
    sb.append("    oneTimePassword: ").append(toIndentedString(oneTimePassword)).append("\n");
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

