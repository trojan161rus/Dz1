package com.trojan.java1.less7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_POS_X = 650;
    private static final int WINDOW_POS_Y = 250;

    private Map map;
    private SettingsWindow settingsWindow;

    GameWindow(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize( WINDOW_WIDTH,WINDOW_HEIGHT);
        setLocation(WINDOW_POS_X,WINDOW_POS_Y);

        setTitle("TicTacToe");
        JButton btnStart =new JButton("Start new game");
        JButton btnStop =new JButton("Exit");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSettings();
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JPanel panBottom = new JPanel();
        panBottom.setLayout(new GridLayout(1, 2));
        panBottom.add(btnStart);
        panBottom.add(btnStop);
        add(panBottom, BorderLayout.SOUTH);
        setResizable(false);

        map = new Map();
        settingsWindow = new SettingsWindow(this);
        add(map,BorderLayout.CENTER);

        setVisible(true);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLen){
        map.startNewGame(mode,fieldSizeX,fieldSizeY,winLen);
    }

    void showSettings(){
        settingsWindow.setVisible(true);
    }
}
