package com.phnaves.exercises3.section3;

class Animal {

    public void sound() {
        System.out.println("Som de animais");
    }
}

class Cat extends Animal {

    @Override
    public void sound() {
        System.out.println("Miau");
    }
}

class Dog extends Animal {}

public class Ex01 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        cat.sound();
        dog.sound();
    }
}
