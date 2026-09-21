package com.phnaves.exercises5b.section2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

class Product implements Comparable<Product> {
    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public int compareTo(Product product) {
        return this.price.compareTo(product.price);
    }
}

public class Ex02 {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Detergente", 5.7),
                new Product("Bala", 4.8),
                new Product("Arroz", 45.78),
                new Product("Detergente", 5.7),
                new Product("Bala", 4.8),
                new Product("chiclete", 4.8),
                new Product("Feijão", 49.8),
                new Product("Macarrão", 49.8),
                new Product("Picanha", 67.45)
        );

        //produtos distintos
        products.stream()
                .distinct()
                .forEach(System.out::println);
        System.out.println();

        //ordenando pelo nome conforme implementado na classe(compareTo)
        products.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        //ordenando pelo nome com comparator
        products.stream()
                .sorted(Comparator.comparing(Product::getName))
                .forEach(System.out::println);
        System.out.println();

        //os tres produtos mais caros
        products.stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(3)
                .forEach(System.out::println);

        //somar o preço dos produtos com reduce
        Double reduce = products.stream()
                .filter(p -> p.getPrice() > 100)
                .map(Product::getPrice)
                .reduce(111.0, (a, b) -> a + b);
        System.out.println(reduce);

        //somar o preço da maneira "correta" (depende do caso)
        System.out.println(products.stream()
                .mapToDouble(Product::getPrice)
                .sum());

        //pelo menos um valor que atenda tal condição passada
        System.out.println(products.stream()
                .anyMatch(p -> p.getPrice() > 50));

        //todas as ocorrencis devem atender tal condição
        System.out.println(products.stream()
                .allMatch(p -> p.getPrice() > 50));

        //nenhuma ocorrencia da condição passada(resultara em true se nao tiver nenhuma)
        System.out.println(products.stream()
                .noneMatch(p -> p.getPrice() > 500));

        //optional com findFirst
        products.stream()
                .filter(p -> p.getName().length() > 54)
                .findFirst()
                .ifPresent(System.out::println);

        //agrupando em um map com chave valor
        Map<Double, List<Product>> collect = products.stream()
                .distinct()
                .collect(Collectors.groupingBy(Product::getPrice));
        System.out.println(collect);
    }
}
