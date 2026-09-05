package com.phnaves.exercises2.section1;

import java.util.List;

public class Ex09 {
    public static void main(String[] args) {
        String password = "Senha123";
        System.out.println(passwordValidator(password));
    }

    private static boolean passwordValidator(String password) {
        return !password.isBlank()
                && password != null
                && password.length() > 0
                && password.chars().anyMatch(Character::isDigit)
                && password.chars().anyMatch(Character::isUpperCase);}
}
