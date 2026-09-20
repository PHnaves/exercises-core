package com.phnaves.exercises5.section1;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }
}

class PersonWithToString {
    private String name;

    public PersonWithToString(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonWithToString{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class Ex01 {
    public static void main(String[] args) {
        System.out.println(new Person("Pedro"));
        System.out.println(new PersonWithToString("Naves"));
    }
}
