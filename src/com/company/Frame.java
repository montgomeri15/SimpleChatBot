package com.company;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {

    private String title = "Чат-бот";
    private String name = "Name:";

    private JPanel panelMain = new JPanel();
    private JPanel panelBottom = new JPanel();

    private JTextArea textAreaMessage = new JTextArea(15,25);
    private JTextField textMessage = new JTextField(15);

    private JLabel labelName = new JLabel(name);
    private JLabel labelSpace1 = new JLabel("    ");
    private JLabel labelSpace2 = new JLabel("    ");
    private JLabel labelSpace3 = new JLabel("    ");
    private JLabel labelSpace4 = new JLabel("    ");
    private JLabel labelSpace5 = new JLabel("    ");

    private JButton buttonSend = new JButton("Тыц");

    protected void ourFrame(){

        setTitle(title);
        setSize(350,360);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        textMessage.setCaretPosition(0);  //Автоматически устанавливаем курсор на первую строку

        //Блок с расположением
        panelMain.setLayout(new GridBagLayout());
        panelBottom.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        panelBottom.add(labelName, c);
        c.gridx = 1;
        c.gridy = 0;
        panelBottom.add(labelSpace1, c);
        c.gridx = 2;
        c.gridy = 0;
        panelBottom.add(textMessage, c);
        c.gridx = 3;
        c.gridy = 0;
        panelBottom.add(labelSpace2, c);
        c.gridx = 4;
        c.gridy = 0;
        panelBottom.add(buttonSend, c);

        c.gridx = 0;
        c.gridy = 0;
        panelMain.add(labelSpace3, c);
        c.gridx = 0;
        c.gridy = 1;
        panelMain.add(textAreaMessage, c);
        c.gridx = 0;
        c.gridy = 2;
        panelMain.add(labelSpace4, c);
        c.gridx = 0;
        c.gridy = 3;
        panelMain.add(panelBottom, c);
        c.gridx = 0;
        c.gridy = 4;
        panelMain.add(labelSpace5, c);

        add(panelMain, BorderLayout.CENTER);

        buttonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonAction();
            }
        });
    }

    protected void buttonAction(){

        String textSave = textAreaMessage.getText();
        textAreaMessage.setText(textSave+"\n"+textMessage.getText());
    }
}

