package com.phnaves.exercises3b.section1;

interface Payment {
    boolean pay(double value);

    default double payForDiscount(double value, double percent) {
        return value - (value * percent / 100);
    }
}

class Ticket implements Payment {

    private double valueForPayment;

    public Ticket(double valueForPayment) {
        this.valueForPayment = valueForPayment;
    }

    @Override
    public boolean pay(double value) {
        return value > valueForPayment;
    }
}

public class Ex01 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket(234.89);

        System.out.println(ticket.pay(300));
        System.out.println(ticket.payForDiscount(100, 10));
    }
}
