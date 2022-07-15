package com.gigacedi.bank.ExceptionHandlers;

public class CustomerAllException extends RuntimeException{

    public CustomerAllException() {
        super("Customer already exist...");
    }
    public CustomerAllException(IllegalArgumentException illegalArgumentException) {
        super("There are more than one Customer with these details...");
    }
    public CustomerAllException(NullPointerException nullPointerException) {
        super("Customer not Found...");
    }

    public CustomerAllException(String firstName, String lastname) {
        super("Customer "+ firstName +" "+ lastname +" exist with different key");
    }
}
