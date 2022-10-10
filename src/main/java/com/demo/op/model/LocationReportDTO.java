package com.demo.op.model;

import java.util.Objects;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * UbicacionReporteDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-21T09:36:06.188-04:00[America/Santo_Domingo]")
public class LocationReportDTO   {

  @JsonProperty("posible")
  private Boolean posible;

  @JsonProperty("message")
  private String message;

  public LocationReportDTO posible(Boolean posible) {
    this.posible = posible;
    return this;
  }

  /**
   * Get posible
   * @return posible
  */
  
  @Schema(name = "posible", required = false)
  public Boolean getPosible() {
    return posible;
  }

  public void setPosible(Boolean posible) {
    this.posible = posible;
  }

  public LocationReportDTO message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
  */
  
  @Schema(name = "message", required = false)
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocationReportDTO ubicacionReporte = (LocationReportDTO) o;
    return Objects.equals(this.posible, ubicacionReporte.posible) &&
        Objects.equals(this.message, ubicacionReporte.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(posible, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UbicacionReporteDTO {\n");
    sb.append("    posible: ").append(toIndentedString(posible)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

