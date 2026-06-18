package com.bank.accountservice.service;

import com.bank.accountservice.Dto.AccountDto;
import com.bank.accountservice.VO.AccountUserResponse;
import com.bank.accountservice.VO.AccountVO;
import com.bank.accountservice.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccountService{

    AccountVO createAccount (AccountDto dto);

    List<AccountVO> getallAccounts();

    AccountVO getByUserId(Long userId);

    AccountUserResponse getAccountWithUser(Long userId);

    AccountVO updateUser(Long id, AccountDto dto);
}
