package com.phnaves.exercises5b.section1;

public class Ex01 {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("Running...");
        };

        Thread thread = new Thread(runnable);

        thread.start();
    }
}
