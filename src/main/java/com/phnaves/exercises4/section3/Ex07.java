package com.phnaves.exercises4.section3;

import java.util.ArrayDeque;

public class Ex07 {
    public static void main(String[] args) {
        ArrayDeque<String> peoples = new ArrayDeque<>();
        peoples.add("Primeira pessoa");
        peoples.add("Segunda pessoa");
        peoples.add("Terceira pessoa");
        peoples.add("Quarta pessoa");
        peoples.offer("Quinta pessoa");
        peoples.push("Primeira pessoa da lista");

        while (!peoples.isEmpty()) System.out.println(peoples.poll());
    }
}
