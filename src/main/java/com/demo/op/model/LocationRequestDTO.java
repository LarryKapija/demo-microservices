package com.demo.op.model;

import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * LocationRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-21T09:36:06.188-04:00[America/Santo_Domingo]")
public class LocationRequestDTO   {

  @JsonProperty("latitud")
  private String latitud;

  @JsonProperty("longitud")
  private String longitud;

  public LocationRequestDTO latitud(String latitud) {
    this.latitud = latitud;
    return this;
  }

  /**
   * Get latitud
   * @return latitud
  */
  @NotNull @Size(max = 50) 
  @Schema(name = "latitud", required = true)
  public String getLatitud() {
    return latitud;
  }

  public void setLatitud(String latitud) {
    this.latitud = latitud;
  }

  public LocationRequestDTO longitud(String longitud) {
    this.longitud = longitud;
    return this;
  }

  /**
   * Get longitud
   * @return longitud
  */
  @NotNull @Size(max = 50) 
  @Schema(name = "longitud", required = true)
  public String getLongitud() {
    return longitud;
  }

  public void setLongitud(String longitud) {
    this.longitud = longitud;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocationRequestDTO locationRequest = (LocationRequestDTO) o;
    return Objects.equals(this.latitud, locationRequest.latitud) &&
        Objects.equals(this.longitud, locationRequest.longitud);
  }

  @Override
  public int hashCode() {
    return Objects.hash(latitud, longitud);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LocationRequestDTO {\n");
    sb.append("    latitud: ").append(toIndentedString(latitud)).append("\n");
    sb.append("    longitud: ").append(toIndentedString(longitud)).append("\n");
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

