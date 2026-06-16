package com.Bank.userservice.Controller;

import com.Bank.userservice.Dto.UserDto;
import com.Bank.userservice.Service.Userservice;
import com.Bank.userservice.VO.UserVO;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final Userservice service;
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    public UserController(Userservice service){
        this.service =service;
    }

    @PostMapping
    public UserVO create (@Valid @RequestBody UserDto dto){
        return service.createUser(dto);
    }

    @GetMapping

    public List<UserVO> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserVO getById(@PathVariable Long id){
        return service.getUserById(id);
    }

    @PutMapping("/{id}")
    public  UserVO update(@PathVariable Long id ,@RequestBody UserDto dto){
        return service.updateUser(id ,dto);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteUser(id);

        return "Deleted ";
    }

    @GetMapping("/health")
    public String health() {
        return "User Service is running";
    }

}
