package com.exceptions_homework;

public class OrderValidationException extends RuntimeException {
    public OrderValidationException(String reason) {
        super("OrderValidation: " + reason);
    }
}
