package com.phnaves.exercises4.section3;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex05 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i != 50_000; i++) {
            numbers.add(i);
        }
        long end = System.nanoTime();
        System.out.println(end - start);

        LinkedList<Integer> numbers2 = new LinkedList<>();
        long start2 = System.nanoTime();
        for (int i = 0; i < 50_000; i++) {
            numbers.add(i);
        }
        long end2 = System.nanoTime();
        System.out.println(end2 - start2);
    }
}
