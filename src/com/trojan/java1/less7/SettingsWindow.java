package com.trojan.java1.less7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {

    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 230;
    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final String FIELD_SIZE_PREFIX = "Field size is: ";
    private static final String WIN_LENGTH_PREFIX = "Win length is: ";

    private GameWindow gameWindow;
    private JRadioButton humVSAI;
    private JRadioButton humVShum;
    private JSlider slideWinLen;
    private JSlider slideFieldSize;

    SettingsWindow(GameWindow gameWindow){
        this.gameWindow = gameWindow;
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(posX,posY);
        setResizable(false);
        setVisible(false);
        setTitle("Creating new game");
        setLayout(new GridLayout(10,1));
        addGameModeControls();
        addFieldControl();
        JButton btnStart = new JButton("Apply settings");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applySettings();
            }

        });
        add(btnStart);

    }

    private void addFieldControl() {
        JLabel lblFieldSize = new JLabel(FIELD_SIZE_PREFIX+MIN_FIELD_SIZE);
        JLabel lblWinLength = new JLabel(WIN_LENGTH_PREFIX+MIN_WIN_LENGTH);
        slideFieldSize = new JSlider(MIN_FIELD_SIZE,MAX_FIELD_SIZE,MIN_FIELD_SIZE);
        slideWinLen = new JSlider(MIN_WIN_LENGTH,MIN_FIELD_SIZE,MIN_WIN_LENGTH);
        slideFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = slideFieldSize.getValue();
                lblFieldSize.setText(FIELD_SIZE_PREFIX+currentValue);
                slideWinLen.setMaximum(currentValue);
            }
        });
        slideWinLen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = slideWinLen.getValue();
                lblWinLength.setText(WIN_LENGTH_PREFIX+currentValue);
            }
        });

        add(new JLabel("Choose field size:"));
        add(lblFieldSize);
        add(slideFieldSize);
        add(new JLabel("Choose win length:"));
        add(lblWinLength);
        add(slideWinLen);
    }

    private void addGameModeControls() {
        add(new JLabel("Choose game mode:"));
        humVSAI = new JRadioButton("Human vs AI");
        humVShum = new JRadioButton("Human vs Human");
        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(humVSAI);
        gameMode.add(humVShum);
        humVSAI.setSelected(true);
        add(humVSAI);
        add(humVShum);
    }

    private void applySettings(){

        int mode;
        if (humVSAI.isSelected())
            mode = Map.MODE_HUMAN_AI;
        else if (humVShum.isSelected())
            mode = Map.MODE_HUMAN_HUMAN;
        else
            throw new RuntimeException("Unexpected gamemode");

        int fieldSize = slideFieldSize.getValue();
        int winLen = slideWinLen.getValue();

        gameWindow.startNewGame(mode,fieldSize,fieldSize,winLen);
        setVisible(false);
    }
}
