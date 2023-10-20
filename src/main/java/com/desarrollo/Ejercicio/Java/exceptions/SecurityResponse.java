package com.desarrollo.Ejercicio.Java.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SecurityResponse {

  private String error;

  public SecurityResponse(String error) {
    this.error = error;
  }
}