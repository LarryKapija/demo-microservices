package com.demo.op.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import javax.annotation.Generated;

/**
 * AsistenciaDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-21T09:36:06.188-04:00[America/Santo_Domingo]")
public class AssistanceDTO   {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("fechaLlamada")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime fechaLlamada;

  @JsonProperty("fechaAsistencia")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime fechaAsistencia;

  @JsonProperty("nombre")
  private String nombre;

  @JsonProperty("apellido")
  private String apellido;

  @JsonProperty("telefono")
  private String telefono;

  @JsonProperty("tipoSituacion")
  private String tipoSituacion;

  @JsonProperty("situacion")
  private String situacion;

  @JsonProperty("placa")
  private String placa;

  @JsonProperty("tipoVehiculo")
  private String tipoVehiculo;

  @JsonProperty("marca")
  private String marca;

  @JsonProperty("modelo")
  private String modelo;

  @JsonProperty("color")
  private String color;

  @JsonProperty("urlImagenFirma")
  private String urlImagenFirma;

  @JsonProperty("latitud")
  private String latitud;

  @JsonProperty("longitud")
  private String longitud;

  @JsonProperty("idTechnician")
  private Long idTechnician;

  @JsonProperty("notasTechnician")
  private String notasTechnician;

  @JsonProperty("tecnico")
  private TechnicianDTO tecnico;

  /**
   * Estado de la asistencia
   */
  public enum EstadoEnum {
    ENVIADA("Enviada"),
    
    ASIGNADA("Asignada"),
    
    EN_PROCESO("En Proceso"),
    
    COMPLETADA("Completada"),
    
    CERRADA("Cerrada");

    private String value;

    EstadoEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EstadoEnum fromValue(String value) {
      for (EstadoEnum b : EstadoEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("estado")
  private EstadoEnum estado;

  public AssistanceDTO id(Long id) {
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

  public AssistanceDTO fechaLlamada(OffsetDateTime fechaLlamada) {
    this.fechaLlamada = fechaLlamada;
    return this;
  }

  /**
   * Get fechaLlamada
   * @return fechaLlamada
  */
  @Valid 
  @Schema(name = "fechaLlamada", required = false)
  public OffsetDateTime getFechaLlamada() {
    return fechaLlamada;
  }

  public void setFechaLlamada(OffsetDateTime fechaLlamada) {
    this.fechaLlamada = fechaLlamada;
  }

  public AssistanceDTO fechaAsistencia(OffsetDateTime fechaAsistencia) {
    this.fechaAsistencia = fechaAsistencia;
    return this;
  }

  /**
   * Get fechaAsistencia
   * @return fechaAsistencia
  */
  @Valid 
  @Schema(name = "fechaAsistencia", required = false)
  public OffsetDateTime getFechaAsistencia() {
    return fechaAsistencia;
  }

  public void setFechaAsistencia(OffsetDateTime fechaAsistencia) {
    this.fechaAsistencia = fechaAsistencia;
  }

  public AssistanceDTO nombre(String nombre) {
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

  public AssistanceDTO apellido(String apellido) {
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

  public AssistanceDTO telefono(String telefono) {
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

  public AssistanceDTO tipoSituacion(String tipoSituacion) {
    this.tipoSituacion = tipoSituacion;
    return this;
  }

  /**
   * Get tipoSituacion
   * @return tipoSituacion
  */
  @Size(max = 100) 
  @Schema(name = "tipoSituacion", required = false)
  public String getTipoSituacion() {
    return tipoSituacion;
  }

  public void setTipoSituacion(String tipoSituacion) {
    this.tipoSituacion = tipoSituacion;
  }

  public AssistanceDTO situacion(String situacion) {
    this.situacion = situacion;
    return this;
  }

  /**
   * Get situacion
   * @return situacion
  */
  @Size(max = 2000) 
  @Schema(name = "situacion", required = false)
  public String getSituacion() {
    return situacion;
  }

  public void setSituacion(String situacion) {
    this.situacion = situacion;
  }

  public AssistanceDTO placa(String placa) {
    this.placa = placa;
    return this;
  }

  /**
   * Get placa
   * @return placa
  */
  @Size(max = 20) 
  @Schema(name = "placa", required = false)
  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }

  public AssistanceDTO tipoVehiculo(String tipoVehiculo) {
    this.tipoVehiculo = tipoVehiculo;
    return this;
  }

  /**
   * Get tipoVehiculo
   * @return tipoVehiculo
  */
  @Size(max = 50) 
  @Schema(name = "tipoVehiculo", required = false)
  public String getTipoVehiculo() {
    return tipoVehiculo;
  }

  public void setTipoVehiculo(String tipoVehiculo) {
    this.tipoVehiculo = tipoVehiculo;
  }

  public AssistanceDTO marca(String marca) {
    this.marca = marca;
    return this;
  }

  /**
   * Get marca
   * @return marca
  */
  @Size(max = 50) 
  @Schema(name = "marca", required = false)
  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public AssistanceDTO modelo(String modelo) {
    this.modelo = modelo;
    return this;
  }

  /**
   * Get modelo
   * @return modelo
  */
  @Size(max = 50) 
  @Schema(name = "modelo", required = false)
  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public AssistanceDTO color(String color) {
    this.color = color;
    return this;
  }

  /**
   * Get color
   * @return color
  */
  @Size(max = 20) 
  @Schema(name = "color", required = false)
  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public AssistanceDTO urlImagenFirma(String urlImagenFirma) {
    this.urlImagenFirma = urlImagenFirma;
    return this;
  }

  /**
   * Get urlImagenFirma
   * @return urlImagenFirma
  */
  @Size(max = 250) 
  @Schema(name = "urlImagenFirma", required = false)
  public String getUrlImagenFirma() {
    return urlImagenFirma;
  }

  public void setUrlImagenFirma(String urlImagenFirma) {
    this.urlImagenFirma = urlImagenFirma;
  }

  public AssistanceDTO latitud(String latitud) {
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

  public AssistanceDTO longitud(String longitud) {
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

  public AssistanceDTO idTechnician(Long idTechnician) {
    this.idTechnician = idTechnician;
    return this;
  }

  /**
   * Get idTechnician
   * @return idTechnician
  */
  
  @Schema(name = "idTechnician", required = false)
  public Long getIdTechnician() {
    return idTechnician;
  }

  public void setIdTechnician(Long idTechnician) {
    this.idTechnician = idTechnician;
  }

  public AssistanceDTO notasTechnician(String notasTechnician) {
    this.notasTechnician = notasTechnician;
    return this;
  }

  /**
   * Get notasTechnician
   * @return notasTechnician
  */
  @Size(max = 2000) 
  @Schema(name = "notasTechnician", required = false)
  public String getNotasTechnician() {
    return notasTechnician;
  }

  public void setNotasTechnician(String notasTechnician) {
    this.notasTechnician = notasTechnician;
  }

  public AssistanceDTO tecnico(TechnicianDTO tecnico) {
    this.tecnico = tecnico;
    return this;
  }

  /**
   * Get tecnico
   * @return tecnico
  */
  @Valid 
  @Schema(name = "tecnico", required = false)
  public TechnicianDTO getTechnician() {
    return tecnico;
  }

  public void setTechnician(TechnicianDTO tecnico) {
    this.tecnico = tecnico;
  }

  public AssistanceDTO estado(EstadoEnum estado) {
    this.estado = estado;
    return this;
  }

  /**
   * Estado de la asistencia
   * @return estado
  */
  
  @Schema(name = "estado", description = "Estado de la asistencia", required = false)
  public EstadoEnum getEstado() {
    return estado;
  }

  public void setEstado(EstadoEnum estado) {
    this.estado = estado;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AssistanceDTO asistencia = (AssistanceDTO) o;
    return Objects.equals(this.id, asistencia.id) &&
        Objects.equals(this.fechaLlamada, asistencia.fechaLlamada) &&
        Objects.equals(this.fechaAsistencia, asistencia.fechaAsistencia) &&
        Objects.equals(this.nombre, asistencia.nombre) &&
        Objects.equals(this.apellido, asistencia.apellido) &&
        Objects.equals(this.telefono, asistencia.telefono) &&
        Objects.equals(this.tipoSituacion, asistencia.tipoSituacion) &&
        Objects.equals(this.situacion, asistencia.situacion) &&
        Objects.equals(this.placa, asistencia.placa) &&
        Objects.equals(this.tipoVehiculo, asistencia.tipoVehiculo) &&
        Objects.equals(this.marca, asistencia.marca) &&
        Objects.equals(this.modelo, asistencia.modelo) &&
        Objects.equals(this.color, asistencia.color) &&
        Objects.equals(this.urlImagenFirma, asistencia.urlImagenFirma) &&
        Objects.equals(this.latitud, asistencia.latitud) &&
        Objects.equals(this.longitud, asistencia.longitud) &&
        Objects.equals(this.idTechnician, asistencia.idTechnician) &&
        Objects.equals(this.notasTechnician, asistencia.notasTechnician) &&
        Objects.equals(this.tecnico, asistencia.tecnico) &&
        Objects.equals(this.estado, asistencia.estado);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, fechaLlamada, fechaAsistencia, nombre, apellido, telefono, tipoSituacion, situacion, placa, tipoVehiculo, marca, modelo, color, urlImagenFirma, latitud, longitud, idTechnician, notasTechnician, tecnico, estado);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AsistenciaDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    fechaLlamada: ").append(toIndentedString(fechaLlamada)).append("\n");
    sb.append("    fechaAsistencia: ").append(toIndentedString(fechaAsistencia)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    apellido: ").append(toIndentedString(apellido)).append("\n");
    sb.append("    telefono: ").append(toIndentedString(telefono)).append("\n");
    sb.append("    tipoSituacion: ").append(toIndentedString(tipoSituacion)).append("\n");
    sb.append("    situacion: ").append(toIndentedString(situacion)).append("\n");
    sb.append("    placa: ").append(toIndentedString(placa)).append("\n");
    sb.append("    tipoVehiculo: ").append(toIndentedString(tipoVehiculo)).append("\n");
    sb.append("    marca: ").append(toIndentedString(marca)).append("\n");
    sb.append("    modelo: ").append(toIndentedString(modelo)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    urlImagenFirma: ").append(toIndentedString(urlImagenFirma)).append("\n");
    sb.append("    latitud: ").append(toIndentedString(latitud)).append("\n");
    sb.append("    longitud: ").append(toIndentedString(longitud)).append("\n");
    sb.append("    idTechnician: ").append(toIndentedString(idTechnician)).append("\n");
    sb.append("    notasTechnician: ").append(toIndentedString(notasTechnician)).append("\n");
    sb.append("    tecnico: ").append(toIndentedString(tecnico)).append("\n");
    sb.append("    estado: ").append(toIndentedString(estado)).append("\n");
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

