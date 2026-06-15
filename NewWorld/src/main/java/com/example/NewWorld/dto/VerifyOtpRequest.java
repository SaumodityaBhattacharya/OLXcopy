package com.example.NewWorld.dto;

public class VerifyOtpRequest {
    private Integer otp;
    private String userEmail;
    public VerifyOtpRequest(){}

    public Integer getOtp() {
        return otp;
    }

    public void setOtp(Integer otp) {
        this.otp = otp;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
