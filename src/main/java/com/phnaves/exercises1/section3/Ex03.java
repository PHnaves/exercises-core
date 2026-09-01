package com.phnaves.exercises1.section3;

enum Options {
    TO_INTEGER,
    TO_DOUBLE,
    TO_BOOLEAN
}

public class Ex03 {
    public static void main(String[] args) {
        String i = "24";
        String d = "1999.90";
        String b = "true";

        convert(i, Options.TO_INTEGER);
        convert(d, Options.TO_DOUBLE);
        convert(b, Options.TO_BOOLEAN);
    }

    private static void convert(String value, Options options) {
        switch (options) {
            case TO_INTEGER -> System.out.println(Integer.parseInt(value));
            case TO_DOUBLE -> System.out.println(Double.parseDouble(value));
            case TO_BOOLEAN -> System.out.println(Boolean.parseBoolean(value));
            default -> System.out.println("errado");
        }
    }
}
