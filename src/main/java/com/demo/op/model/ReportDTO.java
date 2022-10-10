package com.demo.op.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.Valid;
import io.swagger.v3.oas.annotations.media.Schema;


import javax.annotation.Generated;

/**
 * ReporteDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-21T09:36:06.188-04:00[America/Santo_Domingo]")
public class ReportDTO   {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("descripcion")
  private String descripcion;

  @JsonProperty("tipoReporte")
  private String tipoReporte;

  @JsonProperty("longitud")
  private String longitud;

  @JsonProperty("latitud")
  private String latitud;

  @JsonProperty("notas")
  private String notas;

  @JsonProperty("nombre")
  private String nombre;

  @JsonProperty("apellido")
  private String apellido;

  @JsonProperty("correo")
  private String correo;

  @JsonProperty("telefono")
  private String telefono;

  @JsonProperty("fechaCreacion")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime fechaCreacion;

  @JsonProperty("fechaUltActualizacion")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime fechaUltActualizacion;

  @JsonProperty("fotos")
  @Valid
  private List<String> fotos = null;

  @JsonProperty("estado")
  private EstadoReporteDTO estado;

  public ReportDTO id(Long id) {
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

  public ReportDTO descripcion(String descripcion) {
    this.descripcion = descripcion;
    return this;
  }

  /**
   * Get descripcion
   * @return descripcion
  */
  
  @Schema(name = "descripcion", required = false)
  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public ReportDTO tipoReporte(String tipoReporte) {
    this.tipoReporte = tipoReporte;
    return this;
  }

  /**
   * Get tipoReporte
   * @return tipoReporte
  */
  
  @Schema(name = "tipoReporte", required = false)
  public String getTipoReporte() {
    return tipoReporte;
  }

  public void setTipoReporte(String tipoReporte) {
    this.tipoReporte = tipoReporte;
  }

  public ReportDTO longitud(String longitud) {
    this.longitud = longitud;
    return this;
  }

  /**
   * Get longitud
   * @return longitud
  */
  
  @Schema(name = "longitud", required = false)
  public String getLongitud() {
    return longitud;
  }

  public void setLongitud(String longitud) {
    this.longitud = longitud;
  }

  public ReportDTO latitud(String latitud) {
    this.latitud = latitud;
    return this;
  }

  /**
   * Get latitud
   * @return latitud
  */
  
  @Schema(name = "latitud", required = false)
  public String getLatitud() {
    return latitud;
  }

  public void setLatitud(String latitud) {
    this.latitud = latitud;
  }

  public ReportDTO notas(String notas) {
    this.notas = notas;
    return this;
  }

  /**
   * Get notas
   * @return notas
  */
  
  @Schema(name = "notas", required = false)
  public String getNotas() {
    return notas;
  }

  public void setNotas(String notas) {
    this.notas = notas;
  }

  public ReportDTO nombre(String nombre) {
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

  public ReportDTO apellido(String apellido) {
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

  public ReportDTO correo(String correo) {
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

  public ReportDTO telefono(String telefono) {
    this.telefono = telefono;
    return this;
  }

  /**
   * Get telefono
   * @return telefono
  */
  
  @Schema(name = "telefono", required = false)
  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public ReportDTO fechaCreacion(OffsetDateTime fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
    return this;
  }

  /**
   * Get fechaCreacion
   * @return fechaCreacion
  */
  @Valid 
  @Schema(name = "fechaCreacion", required = false)
  public OffsetDateTime getFechaCreacion() {
    return fechaCreacion;
  }

  public void setFechaCreacion(OffsetDateTime fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  public ReportDTO fechaUltActualizacion(OffsetDateTime fechaUltActualizacion) {
    this.fechaUltActualizacion = fechaUltActualizacion;
    return this;
  }

  /**
   * Get fechaUltActualizacion
   * @return fechaUltActualizacion
  */
  @Valid 
  @Schema(name = "fechaUltActualizacion", required = false)
  public OffsetDateTime getFechaUltActualizacion() {
    return fechaUltActualizacion;
  }

  public void setFechaUltActualizacion(OffsetDateTime fechaUltActualizacion) {
    this.fechaUltActualizacion = fechaUltActualizacion;
  }

  public ReportDTO fotos(List<String> fotos) {
    this.fotos = fotos;
    return this;
  }

  public ReportDTO addFotosItem(String fotosItem) {
    if (this.fotos == null) {
      this.fotos = new ArrayList<>();
    }
    this.fotos.add(fotosItem);
    return this;
  }

  /**
   * Get fotos
   * @return fotos
  */
  
  @Schema(name = "fotos", required = false)
  public List<String> getFotos() {
    return fotos;
  }

  public void setFotos(List<String> fotos) {
    this.fotos = fotos;
  }

  public ReportDTO estado(EstadoReporteDTO estado) {
    this.estado = estado;
    return this;
  }

  /**
   * Get estado
   * @return estado
  */
  @Valid 
  @Schema(name = "estado", required = false)
  public EstadoReporteDTO getEstado() {
    return estado;
  }

  public void setEstado(EstadoReporteDTO estado) {
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
    ReportDTO reporte = (ReportDTO) o;
    return Objects.equals(this.id, reporte.id) &&
        Objects.equals(this.descripcion, reporte.descripcion) &&
        Objects.equals(this.tipoReporte, reporte.tipoReporte) &&
        Objects.equals(this.longitud, reporte.longitud) &&
        Objects.equals(this.latitud, reporte.latitud) &&
        Objects.equals(this.notas, reporte.notas) &&
        Objects.equals(this.nombre, reporte.nombre) &&
        Objects.equals(this.apellido, reporte.apellido) &&
        Objects.equals(this.correo, reporte.correo) &&
        Objects.equals(this.telefono, reporte.telefono) &&
        Objects.equals(this.fechaCreacion, reporte.fechaCreacion) &&
        Objects.equals(this.fechaUltActualizacion, reporte.fechaUltActualizacion) &&
        Objects.equals(this.fotos, reporte.fotos) &&
        Objects.equals(this.estado, reporte.estado);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, descripcion, tipoReporte, longitud, latitud, notas, nombre, apellido, correo, telefono, fechaCreacion, fechaUltActualizacion, fotos, estado);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReporteDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    descripcion: ").append(toIndentedString(descripcion)).append("\n");
    sb.append("    tipoReporte: ").append(toIndentedString(tipoReporte)).append("\n");
    sb.append("    longitud: ").append(toIndentedString(longitud)).append("\n");
    sb.append("    latitud: ").append(toIndentedString(latitud)).append("\n");
    sb.append("    notas: ").append(toIndentedString(notas)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    apellido: ").append(toIndentedString(apellido)).append("\n");
    sb.append("    correo: ").append(toIndentedString(correo)).append("\n");
    sb.append("    telefono: ").append(toIndentedString(telefono)).append("\n");
    sb.append("    fechaCreacion: ").append(toIndentedString(fechaCreacion)).append("\n");
    sb.append("    fechaUltActualizacion: ").append(toIndentedString(fechaUltActualizacion)).append("\n");
    sb.append("    fotos: ").append(toIndentedString(fotos)).append("\n");
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

