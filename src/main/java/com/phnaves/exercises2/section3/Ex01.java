package com.phnaves.exercises2.section3;

import java.util.Arrays;

public class Ex01 {
    public static void main(String... args) {
        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        System.out.println(Arrays.toString(numbers));
    }
}
