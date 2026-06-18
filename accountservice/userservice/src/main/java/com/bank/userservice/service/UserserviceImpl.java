package com.bank.userservice.service;

import com.bank.userservice.Entity.User;
import com.bank.userservice.Exception.UserNotFoundException;
import com.bank.userservice.Mapper.UserMapper;
import com.bank.userservice.Repository.UserRepository;
import com.bank.userservice.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserserviceImpl implements  Userservice {

    private final UserRepository repo;


    public UserserviceImpl (UserRepository repo) {
        this.repo = repo;
    }
    @Override
    public UserDto createUser(UserDto dto){
        UserMapper mapper = new UserMapper();
        User user = mapper.toEntity(dto);
    User saved =repo.save(user);

    return mapper.toDto(saved);
    }

    @Override
    public List<UserDto> getAllUsers() {
        UserMapper mapper = new UserMapper();
        return repo.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public UserDto getUserById(Long id) {
        UserMapper mapper = new UserMapper();
        User user= repo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not Found "+id));

        return mapper.toDto(user);
    }

    @Override
    public UserDto updateUser(Long id, UserDto dto) {
        UserMapper mapper = new UserMapper();
        User user =repo.findById(id)
                .orElseThrow(()->new UserNotFoundException("User not Found "+id));
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setAge(dto.getAge());

        return mapper.toDto(repo.save(user));
    }

    @Override
    public void deleteUser(Long id) {

        User user = repo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not Found " + id));

        repo.delete(user);
    }
}








