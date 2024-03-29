package com.fincheck.Users.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fincheck.Auth.dto.LoginDto;
import com.fincheck.Users.models.User;
import com.fincheck.Users.repositories.UserRepository;
import com.fincheck.shared.infra.security.TokenService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserLoginService {
  private UserRepository userRepository;
  private PasswordEncoder passwordEncoder;
  private TokenService tokenService;

  public String execute(LoginDto loginDto) {
    User user = userRepository.findByEmail(loginDto.email()).orElseThrow(() -> new RuntimeException("User not found"));

    if(passwordEncoder.matches(user.getPassword(), loginDto.password())) {
      return this.tokenService.generateToken(user);
    }

    throw new RuntimeException("Inputs provided invalid");
  }
}
