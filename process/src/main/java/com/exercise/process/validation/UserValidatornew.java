package com.exercise.process.validation;

import com.exercise.process.Entity.User;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;



    public class UserValidatornew implements ConstraintValidator<ValidUser, User> {

        private  final Pattern EMAIL_PATTERN = Pattern.compile(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
        );
        private  final Pattern PHONE_PATTERN = Pattern.compile("\\d{10}");
        private  final Pattern PASSWORD_PATTERN = Pattern.compile(
                "^(?=.*[0-9])(?=.*[!@#$%^&*]).{8,}$"
        );

        @Override
        public void initialize(ValidUser constraintAnnotation) {
        }

        @Override
        public boolean isValid(User user, ConstraintValidatorContext context) {
            boolean isValid = true;

            if (user.getName() == null || user.getName().length() < 3 || user.getName().length() > 20) {
                context.buildConstraintViolationWithTemplate("Name must be between 3 and 20 characters")
                        .addPropertyNode("name")
                        .addConstraintViolation();
                isValid = false;
            }

            if (user.getEmail() == null || !EMAIL_PATTERN.matcher(user.getEmail()).matches()) {
                context.buildConstraintViolationWithTemplate("Email should be valid")
                        .addPropertyNode("email")
                        .addConstraintViolation();
                isValid = false;
            }

            if (user.getPhone_no() == null || !PHONE_PATTERN.matcher(user.getPhone_no()).matches()) {
                context.buildConstraintViolationWithTemplate("Phone number must be exactly 10 digits")
                        .addPropertyNode("phoneNumber")
                        .addConstraintViolation();
                isValid = false;
            }

            if (user.getPassword() == null || !PASSWORD_PATTERN.matcher(user.getPassword()).matches()) {
                context.buildConstraintViolationWithTemplate("Password must be at least 8 characters long, contain at least one number and one special character")
                        .addPropertyNode("password")
                        .addConstraintViolation();
                isValid = false;
            }

            if (!isValid) {
                context.disableDefaultConstraintViolation();
            }

            return isValid;
        }
    }
