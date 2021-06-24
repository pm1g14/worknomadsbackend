package com.worknomads.worknomads.validators;

public interface InputValidator<T> {

    public boolean validate(T toBeValidated);
}
