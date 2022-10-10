package com.demo.op.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ReporteResponseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-21T09:36:06.188-04:00[America/Santo_Domingo]")
public class ReporteResponseDTO   {

  @JsonProperty("value")
  private ReportDTO value;

  @JsonProperty("type")
  private String type;

  @JsonProperty("message")
  private String message;

  public ReporteResponseDTO value(ReportDTO value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
  */
  @Valid 
  @Schema(name = "value", required = false)
  public ReportDTO getValue() {
    return value;
  }

  public void setValue(ReportDTO value) {
    this.value = value;
  }

  public ReporteResponseDTO type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  
  @Schema(name = "type", required = false)
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ReporteResponseDTO message(String message) {
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
    ReporteResponseDTO reporteResponse = (ReporteResponseDTO) o;
    return Objects.equals(this.value, reporteResponse.value) &&
        Objects.equals(this.type, reporteResponse.type) &&
        Objects.equals(this.message, reporteResponse.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, type, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReporteResponseDTO {\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

