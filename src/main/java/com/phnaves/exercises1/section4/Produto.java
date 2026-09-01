package com.phnaves.exercises1.section4;

public class Produto {
    private Double preco;

    public Produto(Double preco) {
        this.preco = preco;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}

class Ex01 {
    public static void main(String[] args) {
        Produto p1 = new Produto(10.9);
        Produto p2 = p1;

        p2.setPreco(999.999);
        System.out.println(p1.getPreco());
    }
}