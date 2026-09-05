package com.phnaves.exercises2.section3;

import java.util.Arrays;

public class Ex03 {
    public static void main(String[] args) {
        int[] numbers = new int[]{1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(maxAndMin(numbers)));
    }

    private static int[] maxAndMin(int... numbers) {
        int max = 0;
        int min = 0;

        for (int i = 0; i < numbers.length; i++) {
            max = i;
            min = i;
            for (int j = numbers.length; j > 0; j--) {
                if (j > i) {
                   max = j;
                }

                if (j < i) {
                    min = j;
                }
            }
        }

        return new int[]{min, max};
    }
}
