package com.Bank.userservice.Exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String msg){
        super (msg);
    }
}
