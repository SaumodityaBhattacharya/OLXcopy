package com.example.NewWorld.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="User_Table")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @NotBlank
    private String userName;

    @Email
    private String userEmail;
    private String userPhoneNumber;

    private boolean verified=false;
    @NotBlank
    @Size(min=8,message = "Password should be atleast 8 characters long")
    private String userPassword;
    private LocalDate dob;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;
    private Integer resetOtp;
    private LocalDateTime otpGeneratedAt;
    public User(){
    }

    public User( String userName, String userEmail, String userPhoneNumber, boolean verified, String userPassword, Role role) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
        this.verified= verified;
        this.userPassword = userPassword;
        this.role = role;
    }

//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified= verified;
    }

    public  String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword( String userPassword) {
        this.userPassword = userPassword;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getResetOtp() {
        return resetOtp;
    }

    public void setResetOtp(Integer resetOtp) {
        this.resetOtp = resetOtp;
    }

    public LocalDateTime getOtpGeneratedAt() {
        return otpGeneratedAt;
    }

    public void setOtpGeneratedAt(LocalDateTime otpGeneratedAt) {
        this.otpGeneratedAt = otpGeneratedAt;
    }
}
