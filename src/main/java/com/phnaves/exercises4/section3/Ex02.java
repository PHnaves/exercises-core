package com.phnaves.exercises4.section3;

import java.util.HashMap;
import java.util.Map;

public class Ex02 {
    public static void main(String[] args) {
        Map<String, Integer> products = new HashMap<>();
        products.put("Arroz", 3);
        products.put("Cafe", 2);
        products.put("Feijao", 1);
        System.out.println(products.containsKey("Arroz"));

        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            System.out.println(entry);
        }
    }
}
