package com.phnaves.exercises2.section1;

public class Ex02 {
    public static void main(String[] args) {
        String p1 = "abc";
        String p2 = "abc";
        String p3 = new String("abc");

        //equals compara conteudo
        //== comparar se é p mesmo objeto
        //aqui nesse caso como o conteudo das duas primeiras são iguais o java faz referencia para o
        //mesmo objeto/espaço na memoria, com new forçamos o java reservar um novo espaço
        System.out.println(p1.equals(p2));
        System.out.println(p1 == p2);

        System.out.println(p1.equals(p3));
        System.out.println(p1 == p3);
    }
}
