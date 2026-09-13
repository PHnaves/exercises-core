package com.phnaves.exercises4.section2;

public class InsufficientFunds extends RuntimeException {
    public InsufficientFunds(String message) {
        super(message);
    }

    public InsufficientFunds() {
        super("Founds insufficient");
    }
}
