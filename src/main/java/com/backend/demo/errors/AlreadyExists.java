package com.backend.demo.errors;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AlreadyExists extends RuntimeException {
  public AlreadyExists(String message) {
    super(message);
  };
};