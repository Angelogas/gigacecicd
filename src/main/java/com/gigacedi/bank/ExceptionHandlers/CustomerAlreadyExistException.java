package com.gigacedi.bank.ExceptionHandlers;

public class CustomerAlreadyExistException extends RuntimeException{

    public CustomerAlreadyExistException() {
        super("Customer already exist. Cannot duplicate");
    }

    public CustomerAlreadyExistException(String message) {

        super(message);
    }

    public CustomerAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
