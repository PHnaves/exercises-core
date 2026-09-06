package com.phnaves.exercises3.section1;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Nome: " + name);
        System.out.println("Preco: " + price);
    }
}

public class Ex01 {
    public static void main(String[] args) {
        Product product1 = new Product("Arroz", 34.98);
        Product product2 = new Product("Feijao", 14.8);

        product1.displayDetails();
        product2.displayDetails();
    }
}
