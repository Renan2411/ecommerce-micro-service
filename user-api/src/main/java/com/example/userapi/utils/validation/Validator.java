package com.example.userapi.utils.validation;

import com.example.userapi.exceptions.generics.GenericValidationException;
import com.example.userapi.exceptions.generics.GenericValidationExceptionList;

import java.util.ArrayList;
import java.util.List;

public class Validator<T> {

    private final T t;
    private final List<Throwable> exceptions = new ArrayList<>();

    public Validator(T t) {
        this.t = t;
    }

    public static <T> Validator<T> of(T t) {
        return new Validator<>(t);
    }

    public Validator<T> validate(boolean assertion, String message) {
        if (!assertion) {
            this.exceptions.add(new GenericValidationException(message));
        }

        return this;
    }

    public T get() {
        if (exceptions.isEmpty()) {
            return t;
        }

        throw new GenericValidationExceptionList(exceptions);
    }

}
