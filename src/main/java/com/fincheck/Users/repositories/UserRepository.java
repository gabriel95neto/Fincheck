package com.fincheck.Users.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fincheck.Users.models.User;

public interface UserRepository extends JpaRepository<User, String> {
  Optional<User> findByEmail(String email);
}
