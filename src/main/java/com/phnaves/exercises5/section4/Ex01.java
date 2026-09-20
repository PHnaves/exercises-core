package com.phnaves.exercises5.section4;

import java.time.*;

public class Ex01 {
    public static void main(String[] args) {
        System.out.println(LocalDate.now());
        System.out.println(LocalDateTime.now());

        System.out.println(Period.between(LocalDate.of(2006, Month.JUNE, 23), LocalDate.now()).getYears());
        System.out.println(Duration.between(LocalDateTime.now(), LocalDateTime.now().plusHours(45)).toMinutes());
    }
}
