package com.phnaves.exercises2.section1;

public class Ex07 {
    public static void main(String[] args) {
        String word = "CiC";
        System.out.println(isPalindrome(word));
    }

    public static boolean isPalindrome(String word) {
        StringBuffer reverseWord = new StringBuffer(word).reverse();
        return word.contentEquals(reverseWord);
    }
}
