package com.phnaves.exercises4.section4;

import java.util.ArrayList;
import java.util.List;

class Box<T> {
    private List<T> items = new ArrayList<>();

    public List<T> getItems() {
        return items;
    }

    public T getItem() {
        return items.remove(items.size() - 1);
    }

    public boolean addItem(T item) {
        return items.add(item);
    }
}

public class Ex01 {
    public static void main(String[] args) {
        Box box = new Box();
        System.out.println(box.addItem("Pedro"));
        System.out.println(box.addItem("Naves"));
        System.out.println(box.getItem());
        System.out.println(box.getItem());

        Box box2 = new Box();
        System.out.println(box2.addItem(4));
        System.out.println(box2.addItem(5));
        System.out.println(box2.getItem());
        System.out.println(box2.getItem());
    }
}
