package com.demo.op.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * UbicacionReporteResponseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-21T09:36:06.188-04:00[America/Santo_Domingo]")
public class LocationReportResponseDTO   {

  @JsonProperty("value")
  private LocationReportDTO value;

  @JsonProperty("message")
  private String message;

  public LocationReportResponseDTO value(LocationReportDTO value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
  */
  @Valid 
  @Schema(name = "value", required = false)
  public LocationReportDTO getValue() {
    return value;
  }

  public void setValue(LocationReportDTO value) {
    this.value = value;
  }

  public LocationReportResponseDTO message(String message) {
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
    LocationReportResponseDTO ubicacionReporteResponse = (LocationReportResponseDTO) o;
    return Objects.equals(this.value, ubicacionReporteResponse.value) &&
        Objects.equals(this.message, ubicacionReporteResponse.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UbicacionReporteResponseDTO {\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

