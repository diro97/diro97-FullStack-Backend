package com.example.fullstackbackend.exception;

public class User1NotFoundException extends RuntimeException  {
  public User1NotFoundException(Long id){
    super("Could not found the user  with id"+ id);
  }
}
