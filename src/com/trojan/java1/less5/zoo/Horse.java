package com.trojan.java1.less5.zoo;

import com.trojan.java1.less5.Animal;

public class Horse extends Animal {

    public Horse(String name, int age){
        super(name,age);
    }

    @Override
    public void voice(){System.out.println(name+": Ииииииии-го-го!!!");}

    @Override
    public void run(int run){
        if (run <= 1500){
            System.out.println(name+" бежит "+run+" м.");
        } else {
            System.out.println(name+" не может бежать "+run+" м.");
        }
    }

    @Override
    public void jump(int jump){
        if (run <= 3){
            System.out.println(name+" прыгает на "+jump+" м.");
        } else {
            System.out.println(name+" не может прыгнуть на "+jump+" м.");
        }
    }
}
