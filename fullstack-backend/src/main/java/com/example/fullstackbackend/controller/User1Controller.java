package com.example.fullstackbackend.controller;

import com.example.fullstackbackend.exception.User1NotFoundException;
import com.example.fullstackbackend.model.User1;
import com.example.fullstackbackend.repository.User1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class User1Controller {
  @Autowired
  private User1Repository user1Repository;

  @PostMapping("/user")
  User1 newuser(@RequestBody User1 newUser){
    
    return user1Repository.save(newUser);

  }
  @GetMapping("/users")
  List<User1> getAllusers(){
    return user1Repository.findAll();
  }
  @GetMapping("/user/{id}")
  User1 getUser1ById(@PathVariable Long id){
    return user1Repository.findById(id)
        .orElseThrow(()->new User1NotFoundException(id));
  }
@PutMapping("/user/{id}")
  User1 updateUser1(@RequestBody User1 newUser1,@PathVariable Long id){
    return user1Repository.findById(id)
        .map(user1 -> {
          user1.setUsername(newUser1.getUsername());
          user1.setName(newUser1.getName());
          user1.setEmail(newUser1.getEmail());
          return user1Repository.save(user1);
        }).orElseThrow(()-> new User1NotFoundException(id));
}
@DeleteMapping("/user/{id}")
  String deleteUser(@PathVariable Long id){
    if(!user1Repository.existsById(id)){
      throw new User1NotFoundException(id);
    }
  user1Repository.deleteById(id);
    return "User with id "+id+" has been deleted success";
}
}
