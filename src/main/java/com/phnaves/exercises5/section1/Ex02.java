package com.phnaves.exercises5.section1;

class Product {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Order {
    private int number;
    private Product product;

    public Order(int number, Product product) {
        this.number = number;
        this.product = product;
    }

    @Override
    public String toString() {
        return "Order{" +
                "number=" + number +
                ", product=" + product +
                '}';
    }
}

public class Ex02 {
    public static void main(String[] args) {
        System.out.println(new Order(23, new Product("Arroz")));
    }
}
