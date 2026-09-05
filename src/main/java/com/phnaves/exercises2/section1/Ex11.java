package com.phnaves.exercises2.section1;

public class Ex11 {
    public static void main(String[] args) {
        System.out.println(countPhrase("Pedro Henrique da Silva Naves"));
    }

    private static int countPhrase(String phrase) {
        return phrase.trim().split(" ").length;
    }
}
