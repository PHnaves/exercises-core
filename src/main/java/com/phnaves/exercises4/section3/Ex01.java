package com.phnaves.exercises4.section3;

import java.util.ArrayList;

public class Ex01 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Pedro");
        names.add("Henrique");
        names.add("Naves");
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

        names.remove("Pedro");

        System.out.println(names);
    }
}
