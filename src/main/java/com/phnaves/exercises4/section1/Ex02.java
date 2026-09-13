package com.phnaves.exercises4.section1;

public class Ex02 {
    public static void main(String[] args) {
        for (Colors color : Colors.values()) {
            System.out.println(color.name() + " " +color.ordinal());
        }
    }
}
