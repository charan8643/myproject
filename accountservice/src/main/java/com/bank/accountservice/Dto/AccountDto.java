package com.bank.accountservice.Dto;

import jakarta.validation.constraints.NotBlank;

public class AccountDto {

    private Long userId;

    @NotBlank(message = "Account Number is required")
    private String accountNumber;

    @NotBlank(message = "Account Type is required")
    private String accountType;

    private double balance;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}