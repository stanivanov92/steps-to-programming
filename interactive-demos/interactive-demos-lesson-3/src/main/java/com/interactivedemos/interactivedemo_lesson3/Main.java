package com.interactivedemos.interactivedemo_lesson3;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Cat cat1 = new Cat(1);
        System.out.println(cat1.age);
        Cat cat2 = new Cat(7);
        System.out.println(cat2.age);
    }
}

class Cat {
    public int age;
    public Cat (int age) {
        this.age = age;
    }

    public void incrementAge() {
        this.age++;
    }
}