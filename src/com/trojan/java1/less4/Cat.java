package com.trojan.java1.less4;

public class Cat {
    String name;
    int age;
    String color;


    Cat(String name, int age, String color){
        this.name = name;
        this.age = age;
        this.color = color;
    }

    void voice() {
        System.out.println(name + " meows!");
    }
    void jump(){
        if (age < 5)
            System.out.println(name + " jump!");
    }
}
