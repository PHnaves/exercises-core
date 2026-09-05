package com.phnaves.exercises2.section3;

public class Ex02 {
    public static void main(String[] args) {
        double[] numbers = {7.5, 8.0, 6.5, 9.0, 10.0};
        System.out.println(media(numbers));
    }

    private static double media(double... numbers) {
        double finalMedia = 0d;
        for (int i = 0; i < numbers.length; i++) {
            finalMedia += numbers[i];
        }
        return finalMedia / numbers.length;
    }
}
