package com.trojan.java1.less5;

import com.trojan.java1.less5.zoo.*;

public class TheZoo{
    public static void main(String[] args) {

        Cat c = new Cat("Персик", 5);
        Dog d = new Dog("Шарик", 7);
        Bird b = new Bird("Чижик", 3, 50);
        Snake s = new Snake("Каа", 200);
        Parrot p = new Parrot("Попугай", 3, 50);
        Horse h = new Horse("Horse",10);


        Animal[] zoo = {c,d,b,s,p};

        for (Animal animal : zoo) {
            animal.voice();
            animal.move();
            if (animal instanceof Bird) {
                System.out.println(animal.name + " увеличили вольер");
                Bird bird = (Bird) animal;
                bird.fly();
            }
        }
        b.fly();
        p.speak();
        ((Parrot)zoo[4]).speak();
        h.run(1500);

    }
}
