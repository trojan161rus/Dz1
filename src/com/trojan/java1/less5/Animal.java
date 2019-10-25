package com.trojan.java1.less5;

public abstract class Animal {
    protected String name;
    protected int age;
    protected int run;
    protected int jump;

    public Animal(String name,int age){
        this.name = name;
        this.age = age;
    }

    protected abstract void voice();

    public void move(){
        System.out.println(name+" ходит на лапках");
    }

    public void run(int run){System.out.println(name+" бежит");}

    public void jump(int jump){System.out.println(name+" прыгает");}
}
