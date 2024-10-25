package com.example.hotelbooking.entity;

import com.example.hotelbooking.model.enums.Role;
import jakarta.persistence.*;

import java.util.UUID;

import lombok.*;

@Entity
@Table(name = "user_role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"id", "user"})
public class UserRoleEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @Enumerated(EnumType.STRING)
  private Role role;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserEntity user;
}
