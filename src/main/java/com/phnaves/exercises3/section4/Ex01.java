package com.phnaves.exercises3.section4;

class Animal {

    public void sound() {
        System.out.println("Som de animais");
    }
}

class Cat extends Animal{

    @Override
    public void sound() {
        System.out.println("Miau");
    }
}

class Dog extends Animal{

    @Override
    public void sound() {
        System.out.println("AuAu");
    }
}


public class Ex01 {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.sound();
        Animal[] animals = {
            new Cat(),
            new Dog(),
            new Cat()
        };

        for (int i = 0; i < animals.length; i++) {
            animals[i].sound();
        }
    }
}
