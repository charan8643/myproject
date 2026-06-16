package com.Bank.userservice.Service;


import com.Bank.userservice.Dto.UserDto;
import com.Bank.userservice.Entity.User;
import com.Bank.userservice.Exception.UserNotFoundException;
import com.Bank.userservice.Mapper.UserMapper;
import com.Bank.userservice.Repository.UserRepository;
import com.Bank.userservice.VO.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserserviceImpl implements  Userservice {

    private final UserRepository repo;
    private final UserMapper mapper;

    private static final Logger log = LoggerFactory.getLogger(UserserviceImpl.class);

    public UserserviceImpl(UserRepository repo, UserMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public UserVO createUser(UserDto dto){

        log.info("Creating user {}", dto.getName());

        User user = mapper.toEntity(dto);

        User saved = repo.save(user);

        log.info("User created successfully with id: {}", saved.getId());

        return mapper.toVO(saved);
    }

    @Override
    public List<UserVO> getAllUsers() {

        log.info("Fetching all users");

        return repo.findAll()
                .stream()
                .map(mapper::toVO)
                .toList();

    }

    @Override
    public UserVO getUserById(Long id) {

        log.info("Fetching user with id: {}", id);

        User user = repo.findById(id)
                .orElseThrow(() -> {
                    log.error("User not found with id: {}", id);
                    return new UserNotFoundException("User not found " + id);
                });

        log.info("User found with id: {}", id);

        return mapper.toVO(user);
    }

    @Override
    public UserVO updateUser(Long id, UserDto dto) {

        log.info("Updating user with id: {}", id);

        User user =repo.findById(id)
                .orElseThrow(()->new UserNotFoundException("User not Found "+id));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setAge(dto.getAge());

        User updated = repo.save(user);

        return mapper.toVO(updated);
    }

    @Override
    public void deleteUser(Long id) {

        User user = repo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not Found " + id));

        repo.delete(user);
    }
}








