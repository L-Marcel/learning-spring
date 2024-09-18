package com.backend.demo.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(unique = true)
  private String name;

  @Column(unique = true)
  private String email;

  public User() {
  };

  public User(String name, String email) {
    this.name = name;
    this.email = email;
  };

  public User(User user) {
    this.name = user.name;
    this.email = user.email;
  };

  public String getEmail() {
    return email;
  };

  public void setEmail(String email) {
    this.email = email;
  };

  public UUID getId() {
    return id;
  };

  public void setId(UUID id) {
    this.id = id;
  };

  public String getName() {
    return name;
  };

  public void setName(String name) {
    this.name = name;
  };
};
