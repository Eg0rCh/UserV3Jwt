package com.example.userv3jwt.mapper;

import com.example.userv3jwt.dto.UserDto;
import com.example.userv3jwt.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto userDto);
}
