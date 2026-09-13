package com.phnaves.exercises4.section3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ex04 {
    public static void main(String[] args) {
        List<String> names = List.of("Pedro", "Naves", "Pedro");
        System.out.println(names.size() + " " + names);

        Set<?> names2 = new HashSet<>(names);
        System.out.println(names2.size() + " " + names2);
    }
}
