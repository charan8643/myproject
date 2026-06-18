package com.bank.accountservice.VO;

public class AccountVO {

    private Long userId;
    private String accountNumber;
    private String accountType;
    private double balance;

    public AccountVO() {}

    public AccountVO(Long userId, String accountNumber, String accountType, double balance) {
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    public Long getUserId() {
        return userId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }
}
