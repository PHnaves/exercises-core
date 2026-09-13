package com.phnaves.exercises4.section3;

import java.util.HashSet;
import java.util.Set;

public class Ex03 {
    public static void main(String[] args) {
        Set<String> emails = new HashSet<>();
        emails.add("pnaves001@gmail.com");
        emails.add("pnaves@uorak");
        emails.add("pnaves001@gmail.com");

        System.out.println(emails.size() + " " + emails);
    }
}
