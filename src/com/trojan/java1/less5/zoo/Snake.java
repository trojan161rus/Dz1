package com.trojan.java1.less5.zoo;

import com.trojan.java1.less5.Animal;

public class Snake extends Animal {

    public Snake(String name,int age){
        super(name,age);
    }
    @Override
    public void move(){
        System.out.println(name+" ползает");
    }

    @Override
    public void voice(){
        System.out.println(name+" шипит");
    }
}
