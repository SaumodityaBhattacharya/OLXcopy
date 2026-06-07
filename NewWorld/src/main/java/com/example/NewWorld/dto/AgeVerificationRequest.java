package com.example.NewWorld.dto;
import java.time.LocalDate;

public class AgeVerificationRequest {
    private LocalDate dob;
    public AgeVerificationRequest(){

    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
