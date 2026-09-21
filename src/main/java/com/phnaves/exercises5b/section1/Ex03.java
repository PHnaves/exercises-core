package com.phnaves.exercises5b.section1;

@FunctionalInterface
interface Operation {
    double execute(double a, double b);
}

public class Ex03 {
    public static void main(String[] args) {
        Operation sum = (Double::sum);
        System.out.println(sum.execute(34.9, 0.1));

        Operation multiplier = ((a, b) -> a * b);
        System.out.println(multiplier.execute(2, 3));
    }
}
