package com.trojan.java1.less3;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static final int FIELD_SIZE = 5;
    private static final char HUMAN_DOT = 'X';
    private static final char AI_DOT = 'O';
    private static final char EMPTY_DOT = '_';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    private static int fieldSizeY;
    private static int fieldSizeX;
    private static char[][] field;

    private static void initField(){
        fieldSizeY = FIELD_SIZE;
        fieldSizeX = FIELD_SIZE;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++){
            for (int x = 0; x < fieldSizeX; x++){
                field[y][x] = EMPTY_DOT;
            }
        }
    }

    private static void printField(){
        System.out.println("_y_y_y_");
        for (int y = 0; y < fieldSizeY; y++){
            System.out.print('x');
            for (int x = 0; x < fieldSizeY; x++){
                System.out.print(field[y][x]+ "|");
            }
            System.out.println();
        }
    }

    private static void humanTurn(){
        int x;
        int y;
        do {
            System.out.println("Введите коорджинаты X и Y (от 1 до 3) через пробел");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isEmptyCell(x,y) || !isValidCell(x,y));
        field[y][x] = HUMAN_DOT;
    }

    private static boolean isEmptyCell(int x, int y){
        return field[y][x] == EMPTY_DOT;
    }

    private static boolean isValidCell(int x, int y){
        return x>=0&&x<fieldSizeX&&y>=0&&y<fieldSizeY;
    }

    private static void aiTurn(){
        int x;
        int y;

        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x,y));
        field[y][x] = AI_DOT;
    }

    private static boolean isFieldFull(){
        for (int y = 0; y < fieldSizeY; y++){
            for (int x = 0; x < fieldSizeY; x++){
                if (field[y][x] == EMPTY_DOT) {
                    if (isEmptyCell(x,y))
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkWin(char c){
        int n=0;
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if ((field[y][x] == c))

                if (n>=3) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        while (true){
            initField();
            printField();

            while (true){
                humanTurn();
                printField();
                if (checkWin(HUMAN_DOT)) {
                    System.out.println("Игрок победил!");
                    break;
                }
                if (isFieldFull()){
                    System.out.println("Ничья!");
                    break;
                }
                aiTurn();
                printField();
                if (checkWin(AI_DOT)) {
                    System.out.println("ИИ победил!");
                    break;
                }
                if (isFieldFull()){
                    System.out.println("Ничья!");
                    break;
                }
            }
            //сыграть еще?
            //if !=y break;
        }
    }
}
