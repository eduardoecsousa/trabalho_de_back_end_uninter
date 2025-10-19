package com.trabalhoDeBackEnd.BackEnd.Error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TaredaNotFoundException extends RuntimeException{
  public TaredaNotFoundException(String message) {
    super(message);
  }
}
