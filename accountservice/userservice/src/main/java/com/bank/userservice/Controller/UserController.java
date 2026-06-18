package com.bank.userservice.Controller;

import com.bank.userservice.dto.UserDto;
import com.bank.userservice.service.Userservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final Userservice service;

    public UserController(Userservice service){
        this.service =service;
    }

    @PostMapping
    public UserDto create (@RequestBody UserDto dto){
        return service.createUser(dto);
    }

    @GetMapping

    public List<UserDto> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id){
        return service.getUserById(id);
    }

    @PutMapping("/{id}")
    public  UserDto update(@PathVariable Long id ,@RequestBody UserDto dto){
        return service.updateUser(id ,dto);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
         service.deleteUser(id);

         return "Deleted ";
    }
}
