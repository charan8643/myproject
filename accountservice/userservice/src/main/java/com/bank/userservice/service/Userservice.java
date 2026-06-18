package com.bank.userservice.service;

import com.bank.userservice.dto.UserDto;

import java.util.List;

public interface Userservice {

    UserDto createUser(UserDto dto);
    // creation of user

    List<UserDto> getAllUsers();
    // getAll users

    UserDto getUserById(Long id);
    // get by id

    UserDto updateUser (Long id , UserDto dto);
    // update user by id

    void deleteUser(Long id);
    // delete user..
}
