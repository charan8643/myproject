package com.Bank.userservice.Mapper;


import com.Bank.userservice.Dto.UserDto;
import com.Bank.userservice.Entity.User;
import com.Bank.userservice.VO.UserVO;
import org.springframework.stereotype.Component;

@Component
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

    public UserVO toVO (User user){
        return new UserVO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getAge()
        );
    }
}
