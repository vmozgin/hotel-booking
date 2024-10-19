package com.example.hotelbooking.model.user;

import com.example.hotelbooking.entity.enums.Role;
import java.util.UUID;
import lombok.Data;

@Data
public class UserResponse {

  private UUID id;
  private String name;
  private String email;
  private String password;
  private Role role;
}
