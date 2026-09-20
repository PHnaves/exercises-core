package com.phnaves.exercises5.section4;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class Ex02 {
    public static void main(String[] args) {
        LocalDate dateBirth = LocalDate.of(2006, Month.JUNE, 23);

        System.out.println(Period.between(dateBirth, LocalDate.now()).getYears());
        System.out.println(Period.between(dateBirth, LocalDate.now()).getMonths());
        System.out.println(Period.between(dateBirth, LocalDate.now()).getDays());
    }
}
