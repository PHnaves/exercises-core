package com.phnaves.exercises4.section2;

class Money {
    private double balance;

    public Money(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setValue(double balance) {
        this.balance = balance;
    }

    public boolean drawOut(double valueToDraw) {
        if (valueToDraw > balance) {
            throw new InsufficientFunds("Error to draw value " + valueToDraw + ". Total balance: " + balance);
        }
        return true;
    }
}

public class Ex02 {
    public static void main(String[] args) {
        Money money = new Money(546.9);

        try {
            System.out.println(money.drawOut(5000));
        } catch (InsufficientFunds e) {
            System.out.println(e.getMessage());
        }
    }
}