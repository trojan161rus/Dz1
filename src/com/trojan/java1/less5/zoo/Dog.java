package com.trojan.java1.less5.zoo;

import com.trojan.java1.less5.Animal;

public class Dog extends Animal {

    public Dog(String name,int age){
        super(name,age);
    }

    @Override
    public void voice(){
        System.out.println(name+" гавкает");
    }

    @Override
    public void move(){
        System.out.println(name+" ходит и стучит подковами");
    }

    @Override
    public void run(int run){
        if (run <= 500){
            System.out.println(name+" бежит "+run+" м.");
        } else {
            System.out.println(name+" не может бежать "+run+" м.");
        }
    }

    @Override
    public void jump(int jump){
        if (jump <= 0.5){
            System.out.println(name+" прыгает на "+jump+" м.");
        } else {
            System.out.println(name+" не может прыгнуть на "+jump+" м.");
        }
    }
}
