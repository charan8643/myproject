package com.Bank.userservice.Service;


import com.Bank.userservice.Dto.UserDto;
import com.Bank.userservice.VO.UserVO;

import java.util.List;

public interface Userservice {

    UserVO createUser(UserDto dto);
    // creation of user

    List<UserVO> getAllUsers();
    // getAll users

    UserVO getUserById(Long id);
    // get by id

    UserVO updateUser (Long id , UserDto dto);
    // update user by id

    void deleteUser(Long id);
    // delete user..
}
