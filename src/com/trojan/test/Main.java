package com.trojan.test;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static char[] line = scanner.nextLine().toCharArray();
    private static int[] num = new int[line.length];

    private static StringBuilder checkLen(int[] num){
        StringBuilder line = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < num.length - 1; i++) {
            if (num[i+1] > num[i]) {
                if (tmp.length() == 0) tmp.append(num[i]);
                tmp.append(num[i+1]);
                if (line.length() < tmp.length()) {
                    line.setLength(0);
                    line.append(tmp);
                }
            } else {
                tmp.setLength(0);
            }
        }
        return line;
    }

    private static void charToInt(){
        int i = 0;
        for (char data: line) {
                num[i] = Character.getNumericValue(data);
            i++;
        }
    }

    public static void main(String[] args) {
        charToInt();
        System.out.println(checkLen(num));
    }
}