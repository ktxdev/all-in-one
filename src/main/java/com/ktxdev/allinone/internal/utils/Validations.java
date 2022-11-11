package com.ktxdev.allinone.internal.utils;

import javax.validation.*;
import java.util.HashSet;
import java.util.Set;

public class Validations {
    public static <T> void validate(T t) {
        try(ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            Validator validator = factory.getValidator();

            Set<ConstraintViolation<T>> violations = validator.validate(t);
            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
            }
        }
    }
}
