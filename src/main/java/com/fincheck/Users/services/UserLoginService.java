package com.fincheck.Users.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fincheck.Auth.dto.LoginDto;
import com.fincheck.Users.models.User;
import com.fincheck.Users.repositories.UserRepository;
import com.fincheck.shared.infra.security.TokenService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserLoginService {
  private UserRepository userRepository;
  private PasswordEncoder passwordEncoder;
  private TokenService tokenService;

  public ResponseEntity<String> execute(@Valid LoginDto loginDto) {
    User user = userRepository.findByEmail(loginDto.email()).orElseThrow(() -> new RuntimeException("User not found"));

    if(passwordEncoder.matches(loginDto.password(), user.getPassword())) {
      return new ResponseEntity<String>("{\"accessToken\":\""+this.tokenService.generateToken(user)+"\"}", HttpStatus.CREATED);
    }

    throw new RuntimeException("Inputs provided invalid");
  }
}
