package com.phnaves.exercises4.section3;

import java.util.TreeSet;

public class Ex06 {
    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(5);
        numbers.add(3);
        numbers.add(1);
        numbers.add(2);
        numbers.add(4);

        System.out.println(numbers);

        TreeSet<String> names = new TreeSet<>();
        names.add("B");
        names.add("C");
        names.add("A");

        System.out.println(names);
    }
}
