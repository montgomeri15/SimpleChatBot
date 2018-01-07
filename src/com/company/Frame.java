package com.company;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private JPanel panelMain = new JPanel();
    private JPanel panelUser = new JPanel();
    private JPanel panelBot = new JPanel();
    private JTextArea textAreaUser = new JTextArea(15,20);
    private JTextArea textAreaBot = new JTextArea(15,20);
    private JLabel labelSpace1 = new JLabel("    ");
    private JLabel labelSpace2 = new JLabel("    ");
    private JLabel labelSpace3 = new JLabel("    ");
    private JButton buttonStart = new JButton("Старт");
    private JButton buttonClean = new JButton("Очистить");

    private String name = "Чат-бот";

    protected void Frame(){

        setTitle(name);
        setSize(550,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        textAreaBot.setEditable(false);
        textAreaBot.setBackground(Color.decode("#F4F7FF"));

        //Блок с расположением
        panelUser.setLayout(new GridBagLayout());
        panelBot.setLayout(new GridBagLayout());
        panelMain.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        panelUser.add(textAreaUser, c);
        c.gridx = 0;
        c.gridy = 1;
        panelUser.add(labelSpace1, c);
        c.gridx = 0;
        c.gridy = 2;
        panelUser.add(buttonStart, c);

        c.gridx = 0;
        c.gridy = 0;
        panelBot.add(textAreaBot, c);
        c.gridx = 0;
        c.gridy = 1;
        panelBot.add(labelSpace2, c);
        c.gridx = 0;
        c.gridy = 2;
        panelBot.add(buttonClean, c);

        c.gridx = 0;
        c.gridy = 0;
        panelMain.add(panelUser, c);
        c.gridx = 1;
        c.gridy = 0;
        panelMain.add(labelSpace3, c);
        c.gridx = 2;
        c.gridy = 0;
        panelMain.add(panelBot);

        add(panelMain, BorderLayout.CENTER);
    }
}

