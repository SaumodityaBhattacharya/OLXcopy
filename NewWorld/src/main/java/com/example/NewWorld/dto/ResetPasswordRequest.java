package com.example.NewWorld.dto;

public class ResetPasswordRequest {
    private String userEmail;
    private String newPassword; //User forgots and creates new password
    public ResetPasswordRequest(){}

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
