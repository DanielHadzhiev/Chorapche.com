package com.example.chorapche.validation;

import com.example.chorapche.validation.anotations.ValidPhoneNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

    @Override
    public void initialize(ValidPhoneNumber constraintAnnotation) {
        // Initialization code if needed
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return false; // or true, depending on your requirements
        }
        // Simple regex for phone number validation
        // This regex allows for various phone number formats, including international formats
        String regex = "^\\+?[0-9]{7,15}$";
        return phoneNumber.matches(regex);
    }
}