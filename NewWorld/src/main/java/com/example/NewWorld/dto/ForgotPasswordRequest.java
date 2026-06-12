package com.example.NewWorld.dto;

public class ForgotPasswordRequest {
    private String userEmail;
    private String userPhoneNumber;
    public ForgotPasswordRequest(){}

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }
    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }
}
