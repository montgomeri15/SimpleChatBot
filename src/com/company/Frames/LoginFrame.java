package com.company.Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class LoginFrame extends JFrame {

    private String title = "Логин";

    private JPanel panel = new JPanel();
    private JLabel labelQuestion = new JLabel("Как к вам обращаться?");
    private JLabel labelSpace1 = new JLabel("    ");
    private JLabel labelSpace2 = new JLabel("    ");
    private JTextField textName = new JTextField(15);
    private JButton buttonSave = new JButton("OK");

    public void ourLogin(){

        setTitle(title);
        setSize(240,180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        //Блок с расположением
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        panel.add(labelQuestion, c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(labelSpace1, c);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(textName, c);
        c.gridx = 0;
        c.gridy = 3;
        panel.add(labelSpace2, c);
        c.gridx = 0;
        c.gridy = 4;
        panel.add(buttonSave, c);

        add(panel, BorderLayout.CENTER);

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonLogin();
            }
        });
    }

    protected void buttonLogin(){

        FileWriter writer;
        try {
            writer = new FileWriter("text.txt", false);
            writer.write(textName.getText());
            writer.flush();  //Финализирует выходное состояние, очищая все буферы вывода (чтобы данные легли в файл)
        } catch (IOException e) {
            e.printStackTrace();
        }

        ChatFrame chatFrame = new ChatFrame();
        chatFrame.ourChat();
    }
}
