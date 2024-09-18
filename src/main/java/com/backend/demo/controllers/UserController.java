package com.backend.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import java.util.List;
import com.backend.demo.models.User;
import com.backend.demo.services.UsersService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {
  @Autowired
  private UsersService service;

  @GetMapping("/")
  public ResponseEntity<List<User>> list() {
    return new ResponseEntity<>(service.list(), HttpStatus.OK);
  };

  @GetMapping("/{id}")
  public ResponseEntity<User> get(@PathVariable UUID id) {
    return new ResponseEntity<>(service.get(id), HttpStatus.OK);
  };

  @PostMapping("/")
  public ResponseEntity<User> create(@RequestBody User user) {
    return new ResponseEntity<>(service.create(user), HttpStatus.CREATED);
  };

  @PutMapping("/{id}")
  public ResponseEntity<User> update(@PathVariable UUID id, @RequestBody User user) {
    user.setId(id);
    user = service.update(user);
    return new ResponseEntity<>(user, HttpStatus.OK);
  };

  @DeleteMapping("/{id}")
  public ResponseEntity<User> delete(@PathVariable UUID id) {
    service.delete(id);
    return new ResponseEntity<>(HttpStatus.OK);
  };
};
