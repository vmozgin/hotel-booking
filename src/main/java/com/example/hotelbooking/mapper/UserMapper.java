package com.example.hotelbooking.mapper;

import com.example.hotelbooking.entity.UserEntity;
import com.example.hotelbooking.entity.UserRoleEntity;
import com.example.hotelbooking.model.enums.Role;
import com.example.hotelbooking.model.user.UserRequest;
import com.example.hotelbooking.model.user.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

  UserResponse userEntityToUserResponse(UserEntity userEntity);

  default List<Role> convertRoleEntitiesToRoleList(List<UserRoleEntity> roles) {
    return roles.stream()
            .map(UserRoleEntity::getRole)
            .toList();
  }

  UserEntity userRequestToUserEntity(UserRequest userRequest);

  default List<UserRoleEntity> convert(List<Role> roles) {
    return roles.stream()
            .map(this::convert)
            .toList();
  }

  default UserRoleEntity convert(Role role) {
    var entity = new UserRoleEntity();
    entity.setRole(role);
    return entity;
  }
}
