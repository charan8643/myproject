package com.bank.accountservice.VO;

import com.Bank.userservice.VO.UserVO;

public class AccountUserResponse {

    private AccountVO account;
    private UserVO user;

    public AccountUserResponse(AccountVO account, UserVO user) {
        this.account = account;
        this.user = user;
    }

    public AccountVO getAccount() { return account; }
    public UserVO getUser() { return user; }
}
