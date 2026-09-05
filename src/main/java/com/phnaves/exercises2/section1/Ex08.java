package com.phnaves.exercises2.section1;

public class Ex08 {
    public static void main(String[] args) {
        //performance com StringBuilder/StringBuffer

        String firstString = new String();
        StringBuilder secondString = new StringBuilder();
        StringBuffer threeString = new StringBuffer();

        long initialTime = System.currentTimeMillis();
        for (int i = 0; i <= 5000; i++) {
            secondString = secondString.append(i);
        }
        long finalTime = System.currentTimeMillis() - initialTime;
        System.out.println(finalTime);
    }
}
