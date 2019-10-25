package com.trojan.java1.less7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Map extends JPanel {

    //    private static JLabel lbl1 = new JLabel();
    public static final int MODE_AI_AI = 1;
    public static final int MODE_HUMAN_AI = 2;
    public static final int MODE_HUMAN_HUMAN = 3;

    private static final Random RANDOM = new Random();
    private static final char HUMAN_DOT = 1;
    private static final char AI_DOT = 2;
    private static final char EMPTY_DOT = 0;

    private int[][] field;
    private int fieldSizeX;
    private int fieldSizeY;
    private int winLength;
    private int cellWidth;
    private int cellHeight;
    private boolean initialized;
    private boolean isGameOver;

    private GameWindow gameWindow;
    private Object GameWindow;

    Map(){
//        super(borderLayout);
//        lbl1 = new JLabel("");
//        add(BorderLayout.NORTH, lbl1);
        setBackground(Color.WHITE);
    }



    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength){
        System.out.printf("M: %d, FSX: %d, FSY: %d, WL: %d\n", mode,fieldSizeX,fieldSizeY,winLength);
//         lbl1.setText("M: "+mode+" FSX: "+fieldSizeX+ " FSY: "+fieldSizeY+" WL: "+winLen);

        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;
        this.field = new int[fieldSizeY][fieldSizeX];
        this.initialized = true;
        this.isGameOver = false;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                update(e);
                repaint();
            }
        });

        repaint();
    }

    private void update(MouseEvent e){
        if(isGameOver) return;
        int cellX = e.getX()/cellWidth;
        int cellY = e.getY()/cellHeight;
        System.out.println(cellX+" "+cellY);
        if (!isValidCell(cellX,cellY)||!isEmptyCell(cellX,cellY)) return;
        field[cellY][cellX] = HUMAN_DOT;
        if(checkWin(HUMAN_DOT)){
            isGameOver = true;
            return;
        }
        aiTurn();
        repaint();
        if(checkWin(HUMAN_DOT)){
            isGameOver = true;
            return;
        }
        if (isGameOver) {
            gameWindow.showSettings();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);

    }

    private void render(Graphics g){
        if (!initialized) return;
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        cellHeight = panelHeight / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;
        g.setColor(Color.BLACK);
        for (int i = 0; i <= fieldSizeY; i++){
            int y = i * cellHeight;
            g.drawLine(0,y,panelWidth,y);
        }
        for (int i = 0; i <= fieldSizeX; i++){
            int x = i * cellWidth;
            g.drawLine(x,0,x,panelHeight);
        }
        for (int y = 0; y < fieldSizeY; y++){
            for (int x = 0; x < fieldSizeX; x++){
                if(isEmptyCell(x,y)) continue;
                if(field[y][x] == HUMAN_DOT)
                    g.setColor(Color.BLUE);
                else if(field[y][x] == AI_DOT)
                    g.setColor(Color.RED);
                else
                    throw new RuntimeException("!!!!!"+field[y][x]);
                g.fillOval(x*cellWidth,y*cellHeight,cellWidth,cellHeight);
            }

        }

    }


    private  boolean isEmptyCell(int x, int y){
        return field[y][x] == EMPTY_DOT;
    }

    private  boolean isValidCell(int x, int y){
        return x>=0&&x<fieldSizeX&&y>=0&&y<fieldSizeY;
    }
    private  boolean checkWin(int c){
        int n=0;
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if ((field[y][x] == c))

                    if (n>=winLength) return true;
            }
        }

        return false;
    }
    private  void aiTurn(){
        int x;
        int y;

        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x,y));
        field[y][x] = AI_DOT;
    }

    private  boolean isFieldFull(){
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
}
