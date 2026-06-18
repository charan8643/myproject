package com.bank.accountservice.mapper;

import com.Bank.userservice.VO.UserVO;
import com.bank.accountservice.Dto.AccountDto;
import com.bank.accountservice.VO.AccountUserResponse;
import com.bank.accountservice.VO.AccountVO;
import com.bank.accountservice.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class Accountmapper {

    public Account toEntity (AccountDto dto){
        Account acc = new Account();

        acc.setUserId(dto.getUserId());
        acc.setAccountNumber(dto.getAccountNumber());
        acc.setAccountType(dto.getAccountType());
        acc.setBalance(dto.getBalance());
        return acc;
    }

    public AccountVO toVo (Account acc){
        return new AccountVO(
                acc.getUserId(),
                acc.getAccountNumber(),
                acc.getAccountType(),
                acc.getBalance()
                );
    }


    public AccountUserResponse toAccountUserResponse(Account acc, UserVO user) {

        AccountVO accountVO = toVo(acc);

        return new AccountUserResponse(
                accountVO,
                user
        );
    }


}
