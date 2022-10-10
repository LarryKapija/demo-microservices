package com.demo.op.model;

import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * AsistenciaResponseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-21T09:36:06.188-04:00[America/Santo_Domingo]")
public class AsistanceResponseDTO   {

  @JsonProperty("value")
  private AssistanceDTO value;

  @JsonProperty("type")
  private String type;

  @JsonProperty("message")
  private String message;

  public AsistanceResponseDTO value(AssistanceDTO value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
  */
  @Valid 
  @Schema(name = "value", required = false)
  public AssistanceDTO getValue() {
    return value;
  }

  public void setValue(AssistanceDTO value) {
    this.value = value;
  }

  public AsistanceResponseDTO type(String type) {
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

  public AsistanceResponseDTO message(String message) {
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
    AsistanceResponseDTO asistenciaResponse = (AsistanceResponseDTO) o;
    return Objects.equals(this.value, asistenciaResponse.value) &&
        Objects.equals(this.type, asistenciaResponse.type) &&
        Objects.equals(this.message, asistenciaResponse.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, type, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AsistenciaResponseDTO {\n");
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

