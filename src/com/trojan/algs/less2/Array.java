package com.trojan.algs.less2;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Array {
    private int[] arr;
    private int size;

    public Array(int size){
        this.size = 0;
        this.arr = new int[size];
    }

    int length(){
        return size;
    }
    @Override
    public String toString() {
        if (arr == null) {
            return "null";
        } else {
            int iMax = size-1;
            if (iMax == -1) {
                return "[]";
            } else {
                StringBuilder b = new StringBuilder();
                b.append('[');
                int i = 0;

                while(true) {
                    b.append(arr[i]);
                    if (i == iMax) {
                        return b.append(']').toString();
                    }

                    b.append(", ");
                    ++i;
                }
            }
        }
    }
    void insert(int value){
        if (size >= arr.length - 1){
            int[] temp = arr;
            arr = new int[size*2];
            System.arraycopy(temp,0,arr,0,size);
        }
        arr[size++] = value;
    }

    boolean delete(int value){
        int index =  find(value);
        if (index != -1) {
            System.arraycopy(arr,index + 1,arr,index,size - index - 1);
            size--;
            return true;
        }
        return false;
    }

    int find(int value){
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) return i;
        }
        return -1;
    }

    private void swap(int a, int b){
        int temp = arr[a];
        arr[a] = arr [b];
        arr[b] = temp;
    }

    public void sortBubble(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (arr[j] > arr[j+1]) swap(j,j+1);
            }
        }
    }

    public void sortSelect(){
        int flag;
        for (int i = 0; i < size; i++) {
            flag = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[flag]) flag = j;
            }
            swap(i, flag);
        }
    }

    public void sortInsert(){
        int in;
        for (int out = 1; out < size; out++) {
            int temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1] >= temp){
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
    }

    public boolean hasValue(int value){
        int left = 0;
        int right = size - 1;
        int middle;
        while (left < right){
            middle = (left + right) / 2;
            if(value == arr[middle]){
                return true;
            } else {
                if(value < arr[middle]){
                    right = middle;
                } else {
                    left = middle;
                }
            }
        }
        return false;
    }
    private int findMax(){
        int max;
        max = arr[1];
        for (int i = 0; i < size; i++) {
            if (max < arr[i]) max = arr[i];
        }
        return max;
    }

    private int findMin(){
        int min;
        min = arr[1];
        for (int i = 0; i < size; i++) {
            if (min > arr[i]) min = arr[i];
        }
        return min;
    }

    private void write(int count, int index, int value){
        for (int i = index; i < index+count; i++) {
            arr[i] = value;
        }
    }

    public void sortPigeonhole(){
        int min = findMin();
        int max = findMax();
        int len = max - min;
        int[][] array = new int[2][len+1];
        int r = 0;
        for (int i = min; i < max + 1; i++) {
            array[0][r] = i;
            for (int k = 0; k < size; k++) {
                if (array[0][r] == arr[k]){
                    array[1][r] ++;
                }
            }
            r++;
        }
        int k = 0;
        for (int j = 0; j < len + 1; j++) {
                if (array[1][j] > 0) {write(array[1][j], k, array[0][j]);
                k += array[1][j];}
        }
    }
}
