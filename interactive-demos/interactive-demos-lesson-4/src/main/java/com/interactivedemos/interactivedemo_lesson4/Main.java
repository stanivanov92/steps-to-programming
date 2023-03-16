package com.interactivedemos.interactivedemo_lesson4;

public class Main {
    public static void main(String[] args) {
        String[] names = {"Pesho", "Dragan", "Ivan"};
        OUTER_LOOP:
        for (String name : names) {
            System.out.printf("Driver's Name: %s, Rating: ", name);
            INNER_LOOP:
            for (int i = 0; i < 5; i++) {
                System.out.print("*");
                if (i == 4 && name.contentEquals("Dragan")){
                    break OUTER_LOOP;
                }
            }
            System.out.println();
        }
    }
}