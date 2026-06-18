package com.Bank.userservice.VO;

public class ApiResponse <T>{

    private String message;
    private String status;
    private  T data;

    public ApiResponse(String message, String status, T data){
        this.message=message;
        this.status=status;
        this.data=data;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }
}
