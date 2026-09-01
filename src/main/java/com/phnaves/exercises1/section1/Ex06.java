package com.phnaves.exercises1.section1;

public class Ex06 {
    /*
        Forçando um StackOverFLorError: Acontece quando algo chama ele mesmo, ocasionando
        um loop "finito" cujo é finalizado quando a memoria da Thread que esta executando "acaba"
     */
    public static void main(String[] args) {
        recursiveMethod();
    }

    private static void recursiveMethod() {
        recursiveMethod();
    }
}
