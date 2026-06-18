package com.bank.accountservice.client;


import com.Bank.userservice.VO.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "user-service",
        url = "http://localhost:8089"
)
public interface UserClient {

    @GetMapping("/users/{id}")
    UserVO getUserById(@PathVariable("id") Long id);
}

