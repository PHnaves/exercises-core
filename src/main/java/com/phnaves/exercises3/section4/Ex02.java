package com.phnaves.exercises3.section4;

interface GeometricForm {
    double area();
    double perimeter();
}

class Quad implements GeometricForm {

    private double lado;

    public Quad(double lado) {
        this.lado = lado;
    }

    @Override
    public double area() {
        return lado * lado;
    }

    @Override
    public double perimeter() {
        return 4 * lado;
    }
}

class Triangle implements GeometricForm {

    private double lado;

    public Triangle(double lado) {
        this.lado = lado;
    }

    @Override
    public double area() {
        return (Math.sqrt(3) / 4) * lado * lado;
    }

    @Override
    public double perimeter() {
        return 3 * lado;
    }
}

public class Ex02 {
    public static void main(String[] args) {

        GeometricForm quad = new Quad(15);
        GeometricForm triangle = new Triangle(15);

        System.out.println("Quadrado:");
        System.out.println("Área: " + quad.area());
        System.out.println("Perímetro: " + quad.perimeter());
        System.out.println();
        System.out.println("Triângulo:");
        System.out.println("Área: " + triangle.area());
        System.out.println("Perímetro: " + triangle.perimeter());
    }
}