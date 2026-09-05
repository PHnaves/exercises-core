package com.phnaves.exercises2.section3;

import java.util.Arrays;

public class Ex06 {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];

        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;

        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;

        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.println(matrix[i][j]);
            }
        }

        System.out.println(sumPrincipals(matrix));
    }

    private static int sumPrincipals(int[][] numbersMatrix) {
        int sumTotal = 0;
        for (int i = 0; i < numbersMatrix.length; i++) {
            for (int j = 0; j < numbersMatrix.length; j++) {
                if (i == j) sumTotal += numbersMatrix[i][j];
            }
        }
        return sumTotal;
    }
}
