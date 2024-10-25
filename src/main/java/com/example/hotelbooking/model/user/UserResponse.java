package com.example.hotelbooking.model.user;


import java.util.List;
import java.util.UUID;

import com.example.hotelbooking.model.enums.Role;
import lombok.Data;

@Data
public class UserResponse {

  private UUID id;
  private String name;
  private String email;
  private String password;
  private List<Role> roles;
}
