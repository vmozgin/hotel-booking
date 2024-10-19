package com.example.hotelbooking.repository;

import com.example.hotelbooking.entity.UserEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

  Optional<UserEntity> findUserEntityByName(String name);

  Boolean existsByNameAndEmail(String name, String email);
}
