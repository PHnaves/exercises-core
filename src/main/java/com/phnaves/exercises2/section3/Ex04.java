package com.phnaves.exercises2.section3;

import java.util.Arrays;

public class Ex04 {
    public static void main(String[] args) {
        int[] numbers = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(invertArray(numbers)));
    }

    private static int[] invertArray(int... numbers) {
        int[] invertedArray = new int[numbers.length];

        int count = 0;
        for (int i = numbers.length - 1; i >= 0 ; i--) {
            invertedArray[count++] = numbers[i];
        }
        return invertedArray;
    }
}
