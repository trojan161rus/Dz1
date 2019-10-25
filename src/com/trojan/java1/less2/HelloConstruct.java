package com.trojan.java1.less2;


import java.util.Arrays;

public class HelloConstruct {

    private static boolean checkNum(int a){
        return (a>0);
    }

    private static int power(int base, int sign){
        int res=1;
        for (int i = 0; i < sign; i++){
            res *=base;
        }
        return res;
    }

    private static void pifagor(int size){
        for (int stroka = 1; stroka < size; stroka++){
            for (int stolb = 1; stolb < size; stolb++){
                System.out.printf("%5d",stroka*stolb);

            }System.out.println();
        }
    }

    private static void neoprcikl() {
        int i=1;
        while (i < 10) {
            System.out.printf("i=%d ", i++);


        }
        //do { } while (i < 10);
    }

    private static void massives(){
        int[] arr;
        arr = new int[10];
        arr[0] = 5;
        arr[1] = 10;
        arr[2] = 8;
        for (int i = 0; i < arr.length; i++){
            arr[i] = i;
        }

        System.out.println(Arrays.toString(arr));

        int [] arr1 = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(arr1));

    }

    private static void change(String[] arr){
        arr[0] = "Java";
    }

   public static void main(String[] args) {

      /* final String name0 = "Ivan";
       final String name1 = "Vasily";

       String letterRecepient = "Ivan";
       switch (letterRecepient){
           case name0:
               System.out.println("Ivan");
               break;
           case name1:
               System.out.println("Vasily");
               break;
           default:
               System.out.println("Default");
               break;
       }
       *
       *
       for (int i = 0,  j = 10; i < 10; i++, j += 15){
           System.out.printf("j = " + j + "; ");
       }

       System.out.println(power(2,10));
       */
       //neoprcikl();
       //massives();
       String[] names = {"Ivan", "Vasily", "Petr"};
       String[] sentence = {"Hello", "World", "Java"};
       System.out.println(Arrays.toString(names));
       change(names);
       System.out.println(Arrays.toString(names));
       change(sentence);
       System.out.println(Arrays.toString(sentence));
       int mass[][] = new int[10][10];
       for (int i = 1; i < mass.length; i++){
           for (int j = 1; j < mass.length; j++){
               mass[i][j] = i *j;

           }
       }
        System.out.println(Arrays.deepToString(mass));
}
}