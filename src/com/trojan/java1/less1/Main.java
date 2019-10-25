package com.trojan.java1.less1;

public class Main {

    /*
    1) Написать метод вычисляющий выражение a*(b+(c/d)) и возвращает результат с плавающей точкой,
    где a,b,c,d - целочисленные входные параметры этого метода;
    2) Написать метод, принимающий на вход два целых числа, и проверяющий что их сумма лежит в пределах
    от 10 до 20(включительно), если да - true, нет - false;
    3) Написать метод, которому в качестве параметра передается целое число,
    метод должен проверить положительное ли число, или отрицательное. 0 - положительное. Результат вывести в консоль;
    4) Написать метод, которому в качестве параметра передается строка, обозначающая имя,
    метод должен вернуть приветственное сообщение "Привет, Имя!";
    5) Написать метод, который определит является ли год високосным. Каждый 4-й год является високосным,
    кроме каждого 100й, при этом каждый 400й - високосный. Результат в консоль.
     */

    private static float calculate(int a, int b, int c, int d){
        return a * ( b + ( c*1.0f / d ));
    }

    private static boolean checkSumm(int a, int b){
        return (((a + b)>=10)&&((a + b)<=20));

    }

    private static void checkNum(int a){
        if ((a<0)&&(a!=0)){
            System.out.println("Число "+ a + " отрицательное");
        } else System.out.println("Число "+ a + " положительное");
    }

    private static void printHello(String str){
        System.out.println("Привет, "+ str + "!");
    }

    private static void checkYear(int a){
        if ((((a % 4)==0)&&(a % 100)!=0)||((a % 400)==0)){
                System.out.println("Год "+ a + " високосный");
            }
        else System.out.println("Год "+ a + " не високосный");
    }

    public static void main(String[] args){
        int a = 10;
        int b = -2;
        int c = 3;
        int d = 8;
        int year = 2012;
        String name = "Иван";
        System.out.printf("Задание 1. %d * ( %d + ( %d / %d ) = %f\n",a,b,c,d, calculate(a,b,c,d));
        System.out.printf("Задание 2. 10 <= %d <= 20 - %b\n",a+b,checkSumm(a,b));
        checkNum(b);
        printHello(name);
        checkYear(year);
    }

}
