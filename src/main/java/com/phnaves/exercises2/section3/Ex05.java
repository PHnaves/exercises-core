package com.phnaves.exercises2.section3;

public class Ex05 {
    public static void main(String[] args) {
        String[] names = new String[]{"Pedro", "Henrique", "Pedro", "pedro"};
        System.out.println(countRepeatNameSimple(names));
    }

    private static int countRepeatNameSimple(String... names) {
        String nameVerify = names[0];
        int countRepeat = 0;
        for (int i = 1; i < (names.length); i++) {
            if (nameVerify.equalsIgnoreCase(names[i])) countRepeat++;
        }
        return countRepeat;
    }
}
