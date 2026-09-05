package com.phnaves.exercises2.section1;

import java.util.Arrays;

public class Ex05 {
    public static void main(String[] args) {
        String split = "Maria da Silva Santos";
        String[] s = split.split(" ");
        System.out.println(s[0] + " " + s[s.length - 1]);
    }
}
