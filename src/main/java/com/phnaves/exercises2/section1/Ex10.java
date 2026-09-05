package com.phnaves.exercises2.section1;

public class Ex10 {
    public static void main(String[] args) {
        System.out.println(normalizeName("Pedro Henrique da SIlva Naves  "));
    }

    private static String normalizeName(String name) {
        return name.toLowerCase().strip().replace(" ", ".");
    }
}
