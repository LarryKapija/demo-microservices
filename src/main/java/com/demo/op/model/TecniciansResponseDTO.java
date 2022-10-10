package com.demo.op.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import io.swagger.v3.oas.annotations.media.Schema;


import javax.annotation.Generated;

/**
 * TechniciansResponseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-21T09:36:06.188-04:00[America/Santo_Domingo]")
public class TecniciansResponseDTO   {

  @JsonProperty("value")
  @Valid
  private List<TechnicianDTO> value = null;

  @JsonProperty("type")
  private String type;

  @JsonProperty("message")
  private String message;

  public TecniciansResponseDTO value(List<TechnicianDTO> value) {
    this.value = value;
    return this;
  }

  public TecniciansResponseDTO addValueItem(TechnicianDTO valueItem) {
    if (this.value == null) {
      this.value = new ArrayList<>();
    }
    this.value.add(valueItem);
    return this;
  }

  /**
   * Get value
   * @return value
  */
  @Valid 
  @Schema(name = "value", required = false)
  public List<TechnicianDTO> getValue() {
    return value;
  }

  public void setValue(List<TechnicianDTO> value) {
    this.value = value;
  }

  public TecniciansResponseDTO type(String type) {
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

  public TecniciansResponseDTO message(String message) {
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
    TecniciansResponseDTO tecnicosResponse = (TecniciansResponseDTO) o;
    return Objects.equals(this.value, tecnicosResponse.value) &&
        Objects.equals(this.type, tecnicosResponse.type) &&
        Objects.equals(this.message, tecnicosResponse.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, type, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TechniciansResponseDTO {\n");
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

