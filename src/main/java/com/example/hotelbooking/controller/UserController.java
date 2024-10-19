package com.example.hotelbooking.controller;

import com.example.hotelbooking.exception.UserExistException;
import com.example.hotelbooking.mapper.UserMapper;
import com.example.hotelbooking.model.user.UserRequest;
import com.example.hotelbooking.model.user.UserResponse;
import com.example.hotelbooking.service.UserService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;
  private final UserMapper userMapper;

  @GetMapping("/{id}")
  public ResponseEntity<UserResponse> getById(@PathVariable UUID id) {
    return ResponseEntity.ok(userMapper.userEntityToUserResponse(userService.findById(id)));
  }

  @PostMapping
  public ResponseEntity<UserResponse> create(@RequestBody UserRequest userRequest) {
    var username = userRequest.getName();
    var email = userRequest.getEmail();
    if (userService.userIsExist(username, email)) {
      throw new UserExistException(
              String.format("User already exists with name = %s and email = %s", username, email));
    }
    var newUser = userService.create(userMapper.userRequestToUserEntity(userRequest));

    return ResponseEntity.status(HttpStatus.CREATED)
            .body(userMapper.userEntityToUserResponse(newUser));
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserResponse> update(@PathVariable UUID id, @RequestBody UserRequest userRequest) {
    var userForUpdate = userMapper.userRequestToUserEntity(userRequest);
    userForUpdate.setId(id);

    return ResponseEntity.ok(userMapper.userEntityToUserResponse(userService.update(userForUpdate)));
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable UUID id) {
    userService.deleteById(id);
  }
}
