package com.jose.api.dto.controllers;

import static javax.validation.Validation.buildDefaultValidatorFactory;

public class ValidatedDTO<T> {
    public void validate(T dtoInstance) {
        buildDefaultValidatorFactory().getValidator().validate(dtoInstance);
    }
}
