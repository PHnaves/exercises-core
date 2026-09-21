package com.phnaves.exercises5b.section2;

import java.util.ArrayList;
import java.util.List;

public class Ex01 {
    public static void main(String[] args) {
        List<String> names = List.of("Pedro", "Henrique", "da", "Silva", "Naves");

        //versão basica/obsoleta e mais verbosa
        List<String> filterNames = new ArrayList<>();
        for (String name : names) {
            if (name.length() > 4) {
                filterNames.add(name.toUpperCase());
            }
        }
        System.out.println(filterNames);

        names.stream()
                .filter(s -> s.length() > 4)
                .map(String::toUpperCase)
                .toList()
                .forEach(System.out::println);
    }
}
