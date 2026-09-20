package com.phnaves.exercises5.section2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Items {
    private String type;
    private String name;

    public Items(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Items items = (Items) o;
        return Objects.equals(type, items.type) && Objects.equals(name, items.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name);
    }
}

public class Ex01 {
    public static void main(String[] args) {
        Items items = new Items("Eletronico", "Celular");
        Items items2 = new Items("Eletronico", "Celular");
        System.out.println(items.equals(items2));

        Set<Items> itemsSet = new HashSet<>();
        itemsSet.add(items);
        itemsSet.add(items2);
        System.out.println(itemsSet.size());
    }
}
