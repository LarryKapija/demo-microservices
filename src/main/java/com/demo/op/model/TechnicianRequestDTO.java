package com.demo.op.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.annotation.Generated;

/**
 * TechnicianRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-21T09:36:06.188-04:00[America/Santo_Domingo]")
public class TechnicianRequestDTO   {

  @JsonProperty("nombre")
  private String nombre;

  @JsonProperty("apellido")
  private String apellido;

  @JsonProperty("telefono")
  private String telefono;

  @JsonProperty("latitud")
  private String latitud;

  @JsonProperty("longitud")
  private String longitud;

  public TechnicianRequestDTO nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Get nombre
   * @return nombre
  */
  @NotNull @Size(max = 100) 
  @Schema(name = "nombre", required = true)
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public TechnicianRequestDTO apellido(String apellido) {
    this.apellido = apellido;
    return this;
  }

  /**
   * Get apellido
   * @return apellido
  */
  @NotNull @Size(max = 100) 
  @Schema(name = "apellido", required = true)
  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public TechnicianRequestDTO telefono(String telefono) {
    this.telefono = telefono;
    return this;
  }

  /**
   * Get telefono
   * @return telefono
  */
  @NotNull @Size(max = 100) 
  @Schema(name = "telefono", required = true)
  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public TechnicianRequestDTO latitud(String latitud) {
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

  public TechnicianRequestDTO longitud(String longitud) {
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
    TechnicianRequestDTO tecnicoRequest = (TechnicianRequestDTO) o;
    return Objects.equals(this.nombre, tecnicoRequest.nombre) &&
        Objects.equals(this.apellido, tecnicoRequest.apellido) &&
        Objects.equals(this.telefono, tecnicoRequest.telefono) &&
        Objects.equals(this.latitud, tecnicoRequest.latitud) &&
        Objects.equals(this.longitud, tecnicoRequest.longitud);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombre, apellido, telefono, latitud, longitud);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TechnicianRequestDTO {\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    apellido: ").append(toIndentedString(apellido)).append("\n");
    sb.append("    telefono: ").append(toIndentedString(telefono)).append("\n");
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

