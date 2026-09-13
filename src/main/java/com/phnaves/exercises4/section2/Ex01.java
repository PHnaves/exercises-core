package com.phnaves.exercises4.section2;

public class Ex01 {
    public static void main(String[] args) {
        try {
            System.out.println(23 % 0);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Mensagem que sempre será executada no final");
        }
    }
}
