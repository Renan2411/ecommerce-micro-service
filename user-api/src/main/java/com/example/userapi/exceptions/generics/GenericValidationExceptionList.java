package com.example.userapi.exceptions.generics;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GenericValidationExceptionList extends RuntimeException {

    List<GenericValidationException> exceptions;

    public GenericValidationExceptionList(String message, List<GenericValidationException> exceptions) {
        super(message);
        this.exceptions = exceptions;
    }

    public GenericValidationExceptionList(List<Throwable> throwables) {
        super("");
        this.exceptions = new ArrayList<>();
        throwables.forEach(t -> this.exceptions.add(new GenericValidationException(t.getMessage())));
    }

}
