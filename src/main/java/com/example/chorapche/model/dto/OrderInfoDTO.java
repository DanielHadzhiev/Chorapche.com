package com.example.chorapche.model.dto;

import com.example.chorapche.validation.anotations.ValidPhoneNumber;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class OrderInfoDTO {

   @NotBlank(message = "*Това поле е задължително")
   private String firstName;

   @NotBlank(message = "*Това поле е задължително")
   private String secondName;

    @Email(message = "*Имейлът трябва да съдържа @ между символите")
     private String email;

    @ValidPhoneNumber(message = "*Невалиден номер")
    private String phoneNumber;

    @NotBlank(message = "*Това поле е задължително")
     private String address;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
