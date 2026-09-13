package com.phnaves.exercises4.section4;

import java.util.HashMap;
import java.util.Map;

class Par<A,B> {
    private A varA;
    private B varB;

    public A getVarA() {
        return varA;
    }

    public void setVarA(A varA) {
        this.varA = varA;
    }

    public B getVarB() {
        return varB;
    }

    public void setVarB(B varB) {
        this.varB = varB;
    }

    public Map<A,B> values() {
        Map<A, B> map = new HashMap<>();
        map.put(varA, varB);
        return map;
    }
}

public class Ex02 {
    public static void main(String[] args) {
        Par<String, Integer> par = new Par<>();
        par.setVarA("Pedro");
        par.setVarB(20);
        System.out.println(par.values());

        Par<String, Double> par2 = new Par<>();
        par2.setVarA("Arroz");
        par2.setVarB(34.89);
        System.out.println(par2.values());
    }
}
