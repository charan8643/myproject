package com.bank.userservice.Mapper;

import com.bank.userservice.Entity.User;
import com.bank.userservice.dto.UserDto;

public class UserMapper {

    public UserDto toDto(User user){

        UserDto dto = new UserDto();
        dto.setName(user.getName());
        dto.setAge(user.getAge());
        dto.setEmail(user.getEmail());

        return dto;
    }

    public User toEntity (UserDto dto){

        User user= new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setAge(dto.getAge());

        return user;
    }
}
