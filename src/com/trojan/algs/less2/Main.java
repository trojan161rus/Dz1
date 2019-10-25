package com.trojan.algs.less2;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[2];
        int[] a1 = {1,2,3,4,5};

        Array arr = new Array(5);

        for (int i = 9; i > 0; i--) {
            arr.insert(i);
        }
        arr.insert(-3);
        arr.insert(11);
        arr.insert(9);
        System.out.println(arr);
        arr.sortPigeonhole();
        System.out.println(arr);
    }

}
