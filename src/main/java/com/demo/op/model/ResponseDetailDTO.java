package com.demo.op.model;

import java.util.Objects;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * ResponseDetailDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-21T09:36:06.188-04:00[America/Santo_Domingo]")
public class ResponseDetailDTO   {

  @JsonProperty("field")
  private String field;

  @JsonProperty("message")
  private String message;

  public ResponseDetailDTO field(String field) {
    this.field = field;
    return this;
  }

  /**
   * Get field
   * @return field
  */
  
  @Schema(name = "field", required = false)
  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public ResponseDetailDTO message(String message) {
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
    ResponseDetailDTO responseDetail = (ResponseDetailDTO) o;
    return Objects.equals(this.field, responseDetail.field) &&
        Objects.equals(this.message, responseDetail.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(field, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseDetailDTO {\n");
    sb.append("    field: ").append(toIndentedString(field)).append("\n");
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

