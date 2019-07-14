package com.program.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ResponseExceptionModel {
  private boolean status;
  private String message;
  private HttpStatus httpCode;
  private LocalDateTime dateTime;

  public ResponseExceptionModel(boolean status, String message, HttpStatus httpCode, LocalDateTime dateTime) {
    this.status = status;
    this.message = message;
    this.httpCode = httpCode;
    this.dateTime = dateTime;
  }
  public ResponseExceptionModel(boolean status,String message, HttpStatus httpCode) {
    this.status = status;
    this.message = message;
    this.httpCode = httpCode;
    this.dateTime = LocalDateTime.now();
  }
  public ResponseExceptionModel() {
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public HttpStatus getHttpCode() {
    return httpCode;
  }

  public void setHttpCode(HttpStatus httpCode) {
    this.httpCode = httpCode;
  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

}
