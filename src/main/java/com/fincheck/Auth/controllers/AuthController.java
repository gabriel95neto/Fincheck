package com.fincheck.Auth.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fincheck.Auth.dto.LoginDto;
import com.fincheck.Auth.dto.SignupDto;
import com.fincheck.Users.dtos.UserDto;
import com.fincheck.Users.services.UserLoginService;
import com.fincheck.Users.services.UserRegisterService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
  private UserLoginService userLoginService;
  private UserRegisterService userRegisterService;

  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody @Valid LoginDto loginDto) {
    return this.userLoginService.execute(loginDto);
  }


  @PostMapping("/register")
  public UserDto signup(@RequestBody @Valid SignupDto signupDto) {
    return this.userRegisterService.execute(signupDto);
  }

}
