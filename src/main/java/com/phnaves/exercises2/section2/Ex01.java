package com.phnaves.exercises2.section2;

public class Ex01 {
    public static String name = "Pedro Naves";
    public static int age = 20;
    public static double height = 1.83;

    public static void main(String[] args) {
        System.out.print("Nome: " + name + " Idade: " + age + " Altura: " + height + "\n");
        System.out.printf("Nome: %s, Idade: %d, Altura: %.2f", name, age, height );
    }
}
