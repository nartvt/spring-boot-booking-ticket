package com.program.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ResponseExceptionModel {
  private boolean status;
  private String message;
  private int httpCode;
  private HttpStatus httpMessage;
  private LocalDateTime dateTime;

  public ResponseExceptionModel(boolean status, String message, HttpStatus httpMessage) {
    this.status = status;
    this.message = message;
    this.httpMessage = httpMessage;
    this.httpCode = httpMessage.value();
    this.dateTime = LocalDateTime.now();
  }

  public ResponseExceptionModel() {
  }

  public boolean isStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }

  public HttpStatus getHttpMessage() {
    return httpMessage;
  }

  public int getHttpCode() {
    return httpCode;
  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }

}
