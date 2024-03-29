package com.fincheck.Auth.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fincheck.Auth.dto.LoginDto;
import com.fincheck.Users.services.UserLoginService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("auth")
@AllArgsConstructor
public class AuthController {
  private UserLoginService userLoginService;

  public String login(LoginDto loginDto) {
    return this.userLoginService.execute(loginDto);
  }
}
