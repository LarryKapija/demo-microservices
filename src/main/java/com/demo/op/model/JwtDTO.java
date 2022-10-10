package com.demo.op.model;

import java.util.Objects;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * JwtDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-21T09:36:06.188-04:00[America/Santo_Domingo]")
public class JwtDTO   {

  @JsonProperty("token")
  private String token;

  @JsonProperty("nombre")
  private String nombre;

  @JsonProperty("apellido")
  private String apellido;

  public JwtDTO token(String token) {
    this.token = token;
    return this;
  }

  /**
   * Get token
   * @return token
  */
  
  @Schema(name = "token", required = false)
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public JwtDTO nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Get nombre
   * @return nombre
  */
  
  @Schema(name = "nombre", required = false)
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public JwtDTO apellido(String apellido) {
    this.apellido = apellido;
    return this;
  }

  /**
   * Get apellido
   * @return apellido
  */
  
  @Schema(name = "apellido", required = false)
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
    JwtDTO jwt = (JwtDTO) o;
    return Objects.equals(this.token, jwt.token) &&
        Objects.equals(this.nombre, jwt.nombre) &&
        Objects.equals(this.apellido, jwt.apellido);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, nombre, apellido);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JwtDTO {\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
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

