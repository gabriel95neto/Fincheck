package com.fincheck.exceptions;

public class ConflictError extends RuntimeException {
    public ConflictError(String message) {
      super(message);
    }
}
