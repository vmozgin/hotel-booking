package com.example.hotelbooking.mapper;

import com.example.hotelbooking.entity.UserEntity;
import com.example.hotelbooking.model.user.UserRequest;
import com.example.hotelbooking.model.user.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

  UserResponse userEntityToUserResponse(UserEntity userEntity);

  UserEntity userRequestToUserEntity(UserRequest userRequest);
}
