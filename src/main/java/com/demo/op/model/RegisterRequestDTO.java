package com.demo.op.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import javax.annotation.Generated;

/**
 * RegistroRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-21T09:36:06.188-04:00[America/Santo_Domingo]")
public class RegisterRequestDTO   {

  @JsonProperty("telefono")
  private String telefono;

  @JsonProperty("correo")
  private String correo;

  @JsonProperty("nombre")
  private String nombre;

  @JsonProperty("apellido")
  private String apellido;

  public RegisterRequestDTO telefono(String telefono) {
    this.telefono = telefono;
    return this;
  }

  /**
   * the username
   * @return telefono
  */
  @NotNull 
  @Schema(name = "telefono", description = "the username", required = true)
  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public RegisterRequestDTO correo(String correo) {
    this.correo = correo;
    return this;
  }

  /**
   * Get correo
   * @return correo
  */
  
  @Schema(name = "correo", required = false)
  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public RegisterRequestDTO nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Get nombre
   * @return nombre
  */
  @NotNull 
  @Schema(name = "nombre", required = true)
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public RegisterRequestDTO apellido(String apellido) {
    this.apellido = apellido;
    return this;
  }

  /**
   * Get apellido
   * @return apellido
  */
  @NotNull 
  @Schema(name = "apellido", required = true)
  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegisterRequestDTO registroRequest = (RegisterRequestDTO) o;
    return Objects.equals(this.telefono, registroRequest.telefono) &&
        Objects.equals(this.correo, registroRequest.correo) &&
        Objects.equals(this.nombre, registroRequest.nombre) &&
        Objects.equals(this.apellido, registroRequest.apellido);
  }

  @Override
  public int hashCode() {
    return Objects.hash(telefono, correo, nombre, apellido);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegistroRequestDTO {\n");
    sb.append("    telefono: ").append(toIndentedString(telefono)).append("\n");
    sb.append("    correo: ").append(toIndentedString(correo)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    apellido: ").append(toIndentedString(apellido)).append("\n");
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

