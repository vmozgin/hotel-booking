package com.example.hotelbooking.model.user;

import com.example.hotelbooking.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

  private String name;
  private String password;
  private String email;
  private List<Role> roles;
}
