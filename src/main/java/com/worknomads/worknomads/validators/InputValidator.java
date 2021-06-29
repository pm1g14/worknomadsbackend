package com.worknomads.worknomads.validators;

@FunctionalInterface
public interface InputValidator<T> {

    boolean validate(T toBeValidated);
}
