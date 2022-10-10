package com.demo.op.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * TechnicianDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-21T09:36:06.188-04:00[America/Santo_Domingo]")
public class TechnicianDTO   {

  @JsonProperty("id")
  private Long id;

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

  public TechnicianDTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", required = false)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public TechnicianDTO nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Get nombre
   * @return nombre
  */
  @Size(max = 100) 
  @Schema(name = "nombre", required = false)
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public TechnicianDTO apellido(String apellido) {
    this.apellido = apellido;
    return this;
  }

  /**
   * Get apellido
   * @return apellido
  */
  @Size(max = 100) 
  @Schema(name = "apellido", required = false)
  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public TechnicianDTO telefono(String telefono) {
    this.telefono = telefono;
    return this;
  }

  /**
   * Get telefono
   * @return telefono
  */
  @Size(max = 100) 
  @Schema(name = "telefono", required = false)
  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public TechnicianDTO latitud(String latitud) {
    this.latitud = latitud;
    return this;
  }

  /**
   * Get latitud
   * @return latitud
  */
  @Size(max = 50) 
  @Schema(name = "latitud", required = false)
  public String getLatitud() {
    return latitud;
  }

  public void setLatitud(String latitud) {
    this.latitud = latitud;
  }

  public TechnicianDTO longitud(String longitud) {
    this.longitud = longitud;
    return this;
  }

  /**
   * Get longitud
   * @return longitud
  */
  @Size(max = 50) 
  @Schema(name = "longitud", required = false)
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
    TechnicianDTO tecnico = (TechnicianDTO) o;
    return Objects.equals(this.id, tecnico.id) &&
        Objects.equals(this.nombre, tecnico.nombre) &&
        Objects.equals(this.apellido, tecnico.apellido) &&
        Objects.equals(this.telefono, tecnico.telefono) &&
        Objects.equals(this.latitud, tecnico.latitud) &&
        Objects.equals(this.longitud, tecnico.longitud);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nombre, apellido, telefono, latitud, longitud);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TechnicianDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

