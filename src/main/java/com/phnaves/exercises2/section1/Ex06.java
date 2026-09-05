package com.phnaves.exercises2.section1;

import java.util.Arrays;

public class Ex06 {
    public static final String VOWELS = "[aeiouáéíóúàèìòùâêîôûãõ]";

    public static void main(String[] args) {
        String abc = "abcedario";
        System.out.println(StringCountVowels(abc));
    }

    public static int StringCountVowels(String word) {
        int vowelsQuantity = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.toString(word.charAt(i)).matches(VOWELS)) {
                vowelsQuantity++;
            }
        }
        return vowelsQuantity;
    }
}
