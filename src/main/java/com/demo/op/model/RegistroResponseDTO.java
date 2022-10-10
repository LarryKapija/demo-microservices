package com.demo.op.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * RegistroResponseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-21T09:36:06.188-04:00[America/Santo_Domingo]")
public class RegistroResponseDTO   {

  @JsonProperty("value")
  private RegisterConfirmationDTO value;

  @JsonProperty("type")
  private String type;

  @JsonProperty("message")
  private String message;

  @JsonProperty("messages")
  @Valid
  private List<ResponseDetailDTO> messages = null;

  public RegistroResponseDTO value(RegisterConfirmationDTO value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
  */
  @Valid 
  @Schema(name = "value", required = false)
  public RegisterConfirmationDTO getValue() {
    return value;
  }

  public void setValue(RegisterConfirmationDTO value) {
    this.value = value;
  }

  public RegistroResponseDTO type(String type) {
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

  public RegistroResponseDTO message(String message) {
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

  public RegistroResponseDTO messages(List<ResponseDetailDTO> messages) {
    this.messages = messages;
    return this;
  }

  public RegistroResponseDTO addMessagesItem(ResponseDetailDTO messagesItem) {
    if (this.messages == null) {
      this.messages = new ArrayList<>();
    }
    this.messages.add(messagesItem);
    return this;
  }

  /**
   * Get messages
   * @return messages
  */
  @Valid 
  @Schema(name = "messages", required = false)
  public List<ResponseDetailDTO> getMessages() {
    return messages;
  }

  public void setMessages(List<ResponseDetailDTO> messages) {
    this.messages = messages;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegistroResponseDTO registroResponse = (RegistroResponseDTO) o;
    return Objects.equals(this.value, registroResponse.value) &&
        Objects.equals(this.type, registroResponse.type) &&
        Objects.equals(this.message, registroResponse.message) &&
        Objects.equals(this.messages, registroResponse.messages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, type, message, messages);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegistroResponseDTO {\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
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

