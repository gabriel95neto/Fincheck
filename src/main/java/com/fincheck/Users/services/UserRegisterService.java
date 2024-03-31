package com.fincheck.Users.services;

import java.util.Objects;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fincheck.Auth.dto.SignupDto;
import com.fincheck.Users.dtos.UserDto;
import com.fincheck.Users.dtos.mapper.UserMapper;
import com.fincheck.Users.models.User;
import com.fincheck.Users.repositories.UserRepository;
import com.fincheck.exceptions.ConflictError;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserRegisterService {
  private UserRepository userRepository;
  private PasswordEncoder passwordEncoder;

  public UserDto execute(@Valid SignupDto userDto) {

    Optional<User> userAlready = userRepository.findByEmail(userDto.email());

    if (userAlready.isEmpty()) {
      User user = new User();
      user.setName(userDto.name());
      user.setEmail(userDto.email());
      user.setPassword(passwordEncoder.encode(userDto.password()));

      this.userRepository.save(user);
      return new UserMapper().toDto(user);
    }
    throw new ConflictError("Email is already exist");
  }
}
