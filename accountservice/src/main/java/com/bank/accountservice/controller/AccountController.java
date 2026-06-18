package com.bank.accountservice.controller;

import com.Bank.userservice.Dto.UserDto;
import com.Bank.userservice.VO.UserVO;
import com.bank.accountservice.Dto.AccountDto;
import com.bank.accountservice.VO.AccountUserResponse;
import com.bank.accountservice.VO.AccountVO;
import com.bank.accountservice.entity.Account;
import com.bank.accountservice.service.AccountService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping
    public AccountVO create(@Valid @RequestBody AccountDto dto) {
        return service.createAccount(dto);
    }

    @GetMapping("/all")
    public List<AccountVO> getAll() {
        return service.getallAccounts();
    }

    @GetMapping("/user/{userId}")
    public AccountVO getByUser(@PathVariable Long userId) {
        return service.getByUserId(userId);
    }

    @PostMapping("/update/{id}")
    public AccountVO update(@PathVariable Long id,
                            @RequestBody AccountDto dto) {

        return service.updateUser(id, dto);
    }
    @GetMapping("/with-user/{userId}")
    public AccountUserResponse getAccountWithUser(@PathVariable Long userId) {
        return service.getAccountWithUser(userId);
    }

}