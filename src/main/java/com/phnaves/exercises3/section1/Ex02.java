package com.phnaves.exercises3.section1;

class Book {
    private String title;
    private String author;
    private int numberPages;

    public Book(String title, String author, int numberPages) {
        this.title = title;
        this.author = author;
        this.numberPages = numberPages;
    }

    public void resume() {
        System.out.printf("Titulo %s - Autor %s - Paginas %d \n", title, author, numberPages);
    }
}

public class Ex02 {
    public static void main(String[] args) {
        Book[] books = {
                new Book("O ontem do amanha", "Eu", 12),
                new Book("O ano bissexto", "TU", 456),
                new Book("A semana", "Nos", 234)
        };

        for (int i = 0; i < books.length; i++) {
            books[i].resume();
        }
    }
}
