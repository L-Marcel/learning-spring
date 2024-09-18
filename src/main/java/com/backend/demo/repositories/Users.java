package com.backend.demo.repositories;

import java.util.UUID;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.demo.models.User;

public interface Users extends JpaRepository<User, UUID> {
  boolean existsByEmail(String email);

  boolean existsByName(String name);

  Optional<User> findByName(String name);

  Optional<User> findByEmail(String email);
};