package com.example.hotelbooking.model.user;

import com.example.hotelbooking.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

  private String name;
  private String password;
  private String email;
  private Role role;
}
