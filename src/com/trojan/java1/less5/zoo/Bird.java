package com.trojan.java1.less5.zoo;

import com.trojan.java1.less5.Animal;

public class Bird extends Animal {

    private  int height;

    public Bird(String name,int age, int height){
        super(name,age);
        this.height = height;
    }

    @Override
    public void voice(){
        System.out.println(name+" чирикает");
    }

    public void fly(){
        System.out.println(name+" летает на высоте "+ height + " м.");
    }

    @Override
    public void run(int run){
        if (run <= 5){
            System.out.println(name+" бежит "+run+" м.");
        } else {
            System.out.println(name+" не может бежать "+run+" м.");
        }
    }

    @Override
    public void jump(int jump){
        if (jump <= 0.2){
            System.out.println(name+" прыгает на "+jump+" м.");
        } else {
            System.out.println(name+" не может прыгнуть на "+jump+" м.");
        }
    }
}
