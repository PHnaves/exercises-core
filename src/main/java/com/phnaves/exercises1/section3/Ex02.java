package com.phnaves.exercises1.section3;

import java.util.Scanner;

public class Ex02 {
    private static double total = 0;

    public static void main(String[] args) {
        deposit(0.10);
        deposit(0.10);
        deposit(0.10);
    }

    private static void deposit(double value) {
        total = total + value;
        System.out.println("Valor total atualizado: " + total);
    }
}
