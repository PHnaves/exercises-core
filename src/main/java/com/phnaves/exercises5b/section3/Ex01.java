package com.phnaves.exercises5b.section3;

import java.util.Optional;

public class Ex01 {

    public static void main(String[] args) {

        // criando Optional
        Optional<String> java = Optional.of("Java");
        Optional<String> vazio = Optional.empty();

        String valor = null;
        Optional<String> nullable = Optional.ofNullable(valor);

        System.out.println(java);
        System.out.println(vazio);
        System.out.println(nullable);


        // Verificar se existe valor
        if (java.isPresent()) {
            System.out.println("Tem valor!");
        }

        if (vazio.isEmpty()) {
            System.out.println("Está vazio!");
        }

        // Pegar o valor
        if (java.isPresent()) {
            String linguagem = java.get();
            System.out.println(linguagem);
        }


        // Valor padrão com orElse()
        String resultado = vazio.orElse("Valor padrão");

        System.out.println(resultado);
        // Valor padrão


        // Valor padrão calculado com orElseGet()
        String resultado2 = vazio.orElseGet(() -> "Java");

        System.out.println(resultado2);
        // Java


        // Lançar exceção se estiver vazio
        String resultado3 = java.orElseThrow();

        System.out.println(resultado3);


        // Executar algo somente se tiver valor
        java.ifPresent(valorJava -> {
            System.out.println("Linguagem: " + valorJava);
        });


        // Transformar o valor com map()
        Optional<Integer> tamanho = java.map(String::length);

        System.out.println(tamanho);
        // Optional[4]


        // filter()
        Optional<String> filtrado = java
                .filter(nome -> nome.length() > 3);

        System.out.println(filtrado);
        // Optional[Java]


        // Optional vazio com filter()
        Optional<String> filtrado2 = java
                .filter(nome -> nome.length() > 10);

        System.out.println(filtrado2);
        // Optional.empty()
    }
}