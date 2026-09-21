package com.phnaves.exercises5b.section1;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex02 {
    public static void main(String[] args) {

        //predicate basicamente serve para pergauntar algo
        Predicate<Integer> verifyNumber = (a) -> a > 0;
        System.out.println(verifyNumber.test(4));
        System.out.println(verifyNumber.test(-4));

        //function serve para trasnformar algo, nesse caso de string para integer
        Function<String, Integer> stringSize = (String::length);
        System.out.println(stringSize.apply("Pedro"));
        System.out.println(stringSize.apply("Henrique"));

        //consume serve para consumir algo, mas nao retorna nada
        Consumer<String> toUpperCase = (s -> {
            System.out.println(s.toUpperCase());
        });
        toUpperCase.accept("pedro");

        //supplier serve para fornecer algo a partir de nada
        Supplier<Double> randomNumber = Math::random;
        System.out.println(randomNumber.get());
        System.out.println(randomNumber.get());
        System.out.println(randomNumber.get());
    }
}
