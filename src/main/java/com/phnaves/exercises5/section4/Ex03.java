package com.phnaves.exercises5.section4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Peoples {
    private LocalDate dateBirth;

    public Peoples(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    @Override
    public String toString() {
        return "Peoples{" +
                "dateBirth=" + dateBirth +
                '}';
    }
}

public class Ex03 {
    public static void main(String[] args) {
        List<Peoples> peoples = new ArrayList<>(List.of(
                new Peoples(LocalDate.now()),
                new Peoples(LocalDate.now().minusYears(23)),
                new Peoples(LocalDate.of(2025, 9, 24).minusYears(50))
        ));
        System.out.println(peoples);
        peoples.sort(Comparator.comparing(Peoples::getDateBirth));
        System.out.println(peoples);
    }
}
