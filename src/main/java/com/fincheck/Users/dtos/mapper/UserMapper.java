package com.fincheck.Users.dtos.mapper;

import org.springframework.stereotype.Component;

import com.fincheck.Users.dtos.UserDto;
import com.fincheck.Users.models.User;

@Component
public class UserMapper {
   public UserDto toDto(User user) {
      if (user == null) {
          return null;
      }
      return new UserDto(user.getId(),user.getName(),user.getEmail(), user.getPassword());
    }
}
