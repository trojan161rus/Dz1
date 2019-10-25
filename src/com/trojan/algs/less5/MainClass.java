package com.trojan.algs.less5;

public class MainClass {
    private static void iterPrint(int i){
        while (i >= 0)
            System.out.print(i-- + " ");
        System.out.println("End");
    }


    private static void recursionPrint(int i){
        if (i >= 0){
            System.out.print(i-- +" " );
            recursionPrint(i);
        }else System.out.println("End");
    }

    private static int routes(int x, int y){
        if (x == 0 && y == 0)
            return 0;
        else if (x == 0 || y == 0)
            return 1;
        else
            return routes(x - 1, y) + routes(x, y - 1 );
    }

    static int X = 8;
    static int Y = 8;
    static int QUEENS = 8;
    static int board[][] = new int [Y][X];

    static void inti(){
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                board[i][j] = 0;
            }
        }
    }

    static void printBoard(){
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
    }

    static boolean queens(int n){
        if (!checkBoard()) return false;
        if (n > QUEENS) return true;

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (board[i][j] == 0){
                    board[i][j] = n;
                    if (queens(n+1))
                        return true;
                    board[i][j] = 0;
                }
            }
        }
        return false;
    }

    static boolean checkQueen(int x, int y){
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (board[i][j] != 0){
                    if(!(i == x && j == y)){
                        if (i - x == 0 || j - y == 0){
                            return false;
                        }
                        if (Math.abs(i - x) == Math.abs(j - y)){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    static boolean checkBoard(){
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (board[i][j] != 0){
                    if(!checkQueen(i,j)) return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        iterPrint(5);
//        System.out.println();
//        recursionPrint(5);

//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                System.out.print(String.format("%6d", routes(j,i)));
//            }
//            System.out.println();
//        }

        inti();
        queens(1);
        printBoard();


    }
}
