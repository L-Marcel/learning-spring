package com.backend.demo.services;

import java.util.UUID;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.demo.errors.AlreadyExists;
import com.backend.demo.errors.NotFound;
import com.backend.demo.models.User;
import com.backend.demo.repositories.Users;

@Service
public class UsersService {
  @Autowired
  private Users users;

  public List<User> list() {
    return users.findAll();
  };

  public User get(UUID id) {
    if (!users.existsById(id))
      throw new NotFound("User not found!");
    return users.findById(id).get();
  };

  public User create(User user) {
    if (users.existsByName(user.getName()))
      throw new AlreadyExists("User already exists!");

    if (users.existsByEmail(user.getEmail()))
      throw new AlreadyExists("E-mail already in use!");

    return users.save(new User(user));
  };

  public User update(User user) {
    if (!users.existsById(user.getId()))
      throw new NotFound("User not found!");

    Optional<User> userWithName = users.findByName(user.getName());

    if (userWithName.isPresent() && !userWithName.get().getId().equals(user.getId()))
      throw new AlreadyExists("Name already in use!");

    Optional<User> userWithEmail = users.findByEmail(user.getEmail());

    if (userWithEmail.isPresent() && !userWithEmail.get().getId().equals(user.getId()))
      throw new AlreadyExists("E-mail already in use!");

    return users.save(user);
  };

  public void delete(UUID id) {
    if (!users.existsById(id))
      throw new NotFound("User not found!");
    users.deleteById(id);
  };
};
