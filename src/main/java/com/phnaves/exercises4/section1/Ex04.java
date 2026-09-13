package com.phnaves.exercises4.section1;

public class Ex04 {
    public static void main(String[] args) {
        double valueForTax = 100;

        for (PaymentMethod pay : PaymentMethod.values()) {
            System.out.println(pay.getType());
            System.out.println(pay.calculationTax(valueForTax));
        }
    }
}
