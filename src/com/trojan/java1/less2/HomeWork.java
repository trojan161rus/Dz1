package com.trojan.java1.less2;

import java.util.Arrays;

public class HomeWork {

    private static void changeArr(int[] arr){
        for (int i = 0; i < arr.length; i++){
            arr[i] = (arr[i] == 0)?1:0;
        }
    }

    private static void createArr(int[] arr){
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++){
            arr[i] += arr[i - 1] + 3;
        }
    }

    private static void fixArr(int[] arr){
        for (int i = 0; i < arr.length; i++){
            arr[i] = (arr[i] < 6)?arr[i] * 2:arr[i];
        }
    }

    private static int findMaxInArr(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++){
            max = (arr[i] > max)?arr[i]:max;
        }
        return max;
    }

    private static int findMinInArr(int[] arr){
        int min = arr[0];
        for (int i = 1; i < arr.length; i++){
            min = (arr[i] < min)?arr[i]:min;
        }
        return min;
    }

    private static void create2dArr(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                arr[i][j] = (i == j)?1:0;
            }
        }
    }

    private static boolean findCentrArr(int[] arr){
         int n = 1;
        while (n != arr.length-1) {
            int left = 0;
            int right = 0;
            for (int i = 0; i < n+1; i++) {
                left += arr[i];
            }
            for (int i = arr.length-1; i > n; i--) {
                right += arr[i];
            }
            n++;
            if (left == right) return true;
        }
        return false;
    }

    private static int[] sdvigArr(int[] arr,int a){
        int n = 0;
        int[] array = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
           if (i+a%arr.length<arr.length) array[i+a%arr.length]=arr[i];
           else {
               array[n++]=arr[i];
            }
        }
        return array;
    }

    private static void sdvigNoArr(int[] arr,int a){
        int tmp = 0;
        for (int i = 0; i < a; i++){
            tmp = arr[arr.length-1];
            for (int j = arr.length-1; j > 0; j--){
            arr[j]=arr[j-1];
            }
        arr[0] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,0,1,0,1,1};
        int[] arr5 = {3,1,1,1,1,1,1,4};
        int[] arr1 = new int[8];
        int[] arr2 = {1,5,3,3,11,4,5,3,4,8,9,1};
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int[][] arr3 = new int[5][5];
        System.out.println(Arrays.toString(arr));
        changeArr(arr);
        createArr(arr1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
        fixArr(arr2);
        System.out.println(Arrays.toString(arr2));
        System.out.println(findMaxInArr(arr2));
        System.out.println(findMinInArr(arr2));
        create2dArr(arr3);
        System.out.println(Arrays.deepToString(arr3));
        System.out.println(findCentrArr(arr5));
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(sdvigArr(array,4)));
        sdvigNoArr(array, 4);
        System.out.println(Arrays.toString(array));
    }
}
