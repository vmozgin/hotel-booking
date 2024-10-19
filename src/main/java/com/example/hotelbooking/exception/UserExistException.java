package com.example.hotelbooking.exception;

public class UserExistException extends RuntimeException {

  public UserExistException(String message) {
    super(message);
  }
}
