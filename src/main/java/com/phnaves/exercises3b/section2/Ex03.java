package com.phnaves.exercises3b.section2;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Ex03 {
    public static void main(String[] args) {
        final Person person = new Person("Pedro");

        person.setName("Naves");
        System.out.println(person.getName());
    }
}
