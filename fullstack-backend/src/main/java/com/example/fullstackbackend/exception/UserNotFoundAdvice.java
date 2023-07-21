package com.example.fullstackbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserNotFoundAdvice {
@ResponseBody
@ExceptionHandler(User1NotFoundException.class)
@ResponseStatus(HttpStatus.NOT_FOUND)
  public Map<String,String> exceptionHandler(User1NotFoundException exception){
    Map<String,String>errorMap=new HashMap<>();
  errorMap.put("errorMessage",exception.getMessage());

  return errorMap;
  }


}
