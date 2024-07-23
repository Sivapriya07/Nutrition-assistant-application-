package com.exercise.process.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import com.exercise.process.validation.UserValidatornew;
import java.lang.annotation.*;

@Documented
    @Constraint(validatedBy = UserValidatornew.class)
    @Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ValidUser {
        String message() default "Invalid user data";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }

