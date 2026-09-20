package com.phnaves.exercises5.section4;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Ex04 {
    public static void main(String[] args) {
        LocalDate dateBirth = LocalDate.of(2006, 6, 23);

        System.out.println(dateBirth.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println(dateBirth.with(TemporalAdjusters.lastDayOfMonth()));

        LocalDate now = LocalDate.now();

        //traz o proximo dia, ou seja se hoje for sabado(caso utilizado) nao ira pegar
        System.out.println(now.with(TemporalAdjusters.next(DayOfWeek.SATURDAY)));

        //nextOrSame traz o dia de hoje se atender a o dia escolhido
        System.out.println(now.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)));

        DayOfWeek dayOfWeek = now.with(TemporalAdjusters.lastDayOfMonth()).getDayOfWeek();
        System.out.println(dayOfWeek);

        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            System.out.println(dayOfWeek.minus(1));
        }
    }
}
