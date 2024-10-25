package com.example.hotelbooking.service;

import com.example.hotelbooking.entity.UserEntity;
import com.example.hotelbooking.entity.UserRoleEntity;
import com.example.hotelbooking.exception.EntityNotFoundException;
import com.example.hotelbooking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public UserEntity findById(UUID id) {
    return userRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(
            MessageFormat.format("Пользователь с id = {0} не найден", id)));
  }

  public UserEntity create(UserEntity user) {
    if (user.getRoles() != null) {
      for (UserRoleEntity role : user.getRoles()) {
        role.setUser(user);
      }
    }
    return userRepository.save(user);
  }

  public UserEntity update(UserEntity userForUpdate) {
    var existedUser = findById(userForUpdate.getId());
    existedUser.setName(userForUpdate.getName());
    existedUser.setEmail(userForUpdate.getEmail());
    existedUser.setPassword(userForUpdate.getPassword());
    Optional.ofNullable(userForUpdate.getRoles())
            .ifPresent(rolesForUpdate -> rolesForUpdate.stream()
                    .filter(roleForUpdate -> !existedUser.getRoles().contains(roleForUpdate))
                    .forEach(roleForUpdate -> {
                      roleForUpdate.setUser(existedUser);
                      existedUser.getRoles().add(roleForUpdate);
                    }));

    return userRepository.save(existedUser);
  }

  public void deleteById(UUID id) {
    userRepository.deleteById(id);
  }

  public UserEntity findByName(String name) {
    return userRepository.findUserEntityByName(name).orElseThrow(()-> new EntityNotFoundException(
            MessageFormat.format("Пользователь с name = {0} не найден", name)));
  }

  public boolean userIsExist(String username, String email) {
    return userRepository.existsByNameAndEmail(username, email);
  }
}
