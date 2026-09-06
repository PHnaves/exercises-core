package com.phnaves.exercises3.section2;

import java.time.LocalDate;

class UserDetails {
    private String name;
    private int dateNas;

    public UserDetails(String name, int dateNas) {
        this.name = name;
        this.dateNas = dateNas;
    }

    public int getAge() {
        return LocalDate.now().getYear() - dateNas;
    }
}

public class Ex01 {
    public static void main(String[] args) {
        UserDetails userDetails = new UserDetails("Pedro Naves", 2006);
        System.out.println(userDetails.getAge());
    }
}
