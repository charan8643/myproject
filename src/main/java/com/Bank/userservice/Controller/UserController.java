package com.Bank.userservice.Controller;

import com.Bank.userservice.Dto.UserDto;
import com.Bank.userservice.Service.Userservice;
import com.Bank.userservice.VO.ApiResponse;
import com.Bank.userservice.VO.UserVO;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponse<UserVO>> create(@Valid @RequestBody UserDto dto) {

        UserVO user = service.createUser(dto);

        return ResponseEntity.status(201)
                .body(new ApiResponse<>("SUCCESS", "User created successfully", user));
    }

    @GetMapping

    public ResponseEntity<ApiResponse<List<UserVO>>> getAllUsers(){
        List <UserVO> vo = service.getAllUsers();

        return ResponseEntity.ok(
                new ApiResponse<>("SUCCESS ", "All users received",vo)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserVO>> getbyId(@PathVariable Long id){
        UserVO vo = service.getUserById(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Success","User fetched" , vo)
        );
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

}
