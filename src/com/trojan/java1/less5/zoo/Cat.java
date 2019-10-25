package com.trojan.java1.less5.zoo;

import com.trojan.java1.less5.Animal;

public class Cat extends Animal {

    public Cat(String name,int age){
        super(name,age);
    }
    @Override
    public void voice(){
        System.out.println(name+" мяукает");
    }

    @Override
    public void run(int run){
        if (run <= 200){
            System.out.println(name+" бежит "+run+" м.");
        } else {
            System.out.println(name+" не может бежать "+run+" м.");
        }
    }

    @Override
    public void jump(int jump){
        if (run <= 2){
            System.out.println(name+" прыгает на "+jump+" м.");
        } else {
            System.out.println(name+" не может прыгнуть на "+jump+" м.");
        }
    }
}
