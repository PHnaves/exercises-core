package com.phnaves.exercises5.section3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Product implements Comparable<Product>{
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Product product) {
        return Double.compare(price, product.price);
    }
}

class ProductComparator implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        return p1.getName().compareTo(p2.getName());
    }
}

public class Ex01 {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Arroz", 35.98));
        productList.add(new Product("Detergente", 3.98));
        productList.add(new Product("Bala", 0.98));
        System.out.println(productList);

        //ordenando pela implementação do comparable
        Collections.sort(productList);
        System.out.println(productList);

        //ordenando pela a classe comparator
        productList.sort(new ProductComparator());
        System.out.println(productList);

        //reverso
        productList.sort(Comparator.comparing(Product::getName).reversed());
        System.out.println(productList);


    }
}
