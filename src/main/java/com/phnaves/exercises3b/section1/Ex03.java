package com.phnaves.exercises3b.section1;

interface ValidValue {
    static boolean validator(double value) {
        return value > 0;
    }
}

public class Ex03 {
    public static void main(String[] args) {
        System.out.println(ValidValue.validator(60));
    }
}
