package com.example.hotelbooking.service;

import com.example.hotelbooking.entity.UserEntity;
import com.example.hotelbooking.exception.EntityNotFoundException;
import com.example.hotelbooking.repository.UserRepository;
import java.text.MessageFormat;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public UserEntity findById(UUID id) {
    return userRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(
            MessageFormat.format("Пользователь с id = {0} не найден", id)));
  }

  public UserEntity create(UserEntity user) {
    return userRepository.save(user);
  }

  public UserEntity update(UserEntity user) {
    var existedUser = findById(user.getId());
    existedUser.setRole(user.getRole());
    existedUser.setName(user.getName());
    existedUser.setEmail(user.getEmail());
    existedUser.setPassword(user.getPassword());

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
