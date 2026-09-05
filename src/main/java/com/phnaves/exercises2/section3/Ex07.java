package com.phnaves.exercises2.section3;

import java.util.Arrays;

public class Ex07 {
    public static void main(String[] args) {
        String[] products = new String[]{"Arroz", "Feijao", "Acucar"};
        double[] values = new double[]{   29.90,   17.89,    15.69};

        System.out.println(Arrays.toString(concatArraysValues(products,values)));
    }

    private static String[] concatArraysValues(String[] products, double[] values) {
        String[] concat = new String[products.length];

        for (int i = 0; i < products.length; i++) {
            concat[i] = "Produto: " + products[i] + " Preco: " + values[i];
        }

        return concat;
    }
}
