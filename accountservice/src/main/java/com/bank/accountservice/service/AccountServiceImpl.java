package com.bank.accountservice.service;

import com.Bank.userservice.Exception.UserNotFoundException;
import com.Bank.userservice.VO.UserVO;
import com.bank.accountservice.Dto.AccountDto;
import com.bank.accountservice.Exception.AccountNotFoundException;
import com.bank.accountservice.VO.AccountUserResponse;
import com.bank.accountservice.VO.AccountVO;
import com.bank.accountservice.client.UserClient;
import com.bank.accountservice.entity.Account;
import com.bank.accountservice.mapper.Accountmapper;
import com.bank.accountservice.repository.AccountRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepo repo;
    private final Accountmapper mapper;
    private final UserClient userClient;

    public AccountServiceImpl(AccountRepo repo, Accountmapper mapper, UserClient userClient){
        this.repo=repo;
        this.mapper =mapper;
        this.userClient = userClient;
    }

    @Override
    public AccountVO createAccount(AccountDto dto) {
        Account acc = mapper.toEntity(dto);

        return mapper.toVo(repo.save(acc));

    }

    @Override
    public List<AccountVO> getallAccounts() {

        return repo.findAll()
                .stream()
                .map(mapper::toVo)
                .toList();
    }

    @Override
    public AccountVO getByUserId(Long userId) {
        Account acc =repo.findByUserId(userId)
                .orElseThrow(()-> new AccountNotFoundException("Account not found"));
        return  mapper.toVo(acc);
    }


    public AccountUserResponse getAccountWithUser(Long userId) {

        Account acc = repo.findByUserId(userId)
                .orElseThrow(() -> new AccountNotFoundException("Account not found"));


        UserVO user = userClient.getUserById(userId);

        System.out.println("User fetched: " + user.getName());

        return mapper.toAccountUserResponse(acc,user);
    }

    @Override
    public AccountVO updateUser(Long id, AccountDto dto) {
        Account acc =repo.findByUserId(id)
                .orElseThrow(()-> new UserNotFoundException("User not Found "+id));

        acc.setAccountType(dto.getAccountType());
        acc.setAccountNumber(dto.getAccountNumber());
        acc.setUserId(dto.getUserId());

        Account updated = repo.save(acc);
        return mapper.toVo(updated);
    }

}
