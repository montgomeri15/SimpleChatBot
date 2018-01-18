package com.company.Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ChatFrame extends JFrame {

    private String title = "Чат-бот";
    String name;

    private JPanel panelMain = new JPanel();
    private JPanel panelBottom = new JPanel();

    private JTextArea textAreaMessage = new JTextArea(15,45);
    JScrollPane scrollPane = new JScrollPane(textAreaMessage);
    private JTextField textMessage = new JTextField(20);

    private JLabel labelName = new JLabel();  //Имя задается из логина
    private JLabel labelSpace1 = new JLabel("    ");
    private JLabel labelSpace2 = new JLabel("    ");
    private JLabel labelSpace3 = new JLabel("    ");

    private JButton buttonSend = new JButton("OK");

    protected void ourChat(){

        setTitle(title);
        setSize(550,360);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        textAreaMessage.setEditable(false);
        textAreaMessage.setLineWrap(true);  //Строки укладываются в несколько строк вместо одной, уходящей за границы компонента

        //Считываем labelName из логина через текст. файл
        try {
            List<String> mass = Files.readAllLines(Paths.get("text.txt"));
            name = mass.get(0)+":";
            labelName.setText(name);
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        panelMain.add(scrollPane, c);
        c.gridx = 0;
        c.gridy = 1;
        panelMain.add(labelSpace3, c);
        c.gridx = 0;
        c.gridy = 2;
        panelMain.add(panelBottom, c);

        add(panelMain, BorderLayout.CENTER);

        buttonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonAction();
            }
        });
        //Также делаем кнопкой по умолчанию
        JRootPane rootPane = SwingUtilities.getRootPane(buttonSend);
        rootPane.setDefaultButton(buttonSend);
        //И фокусируем на текстфилд
        textMessage.requestFocusInWindow();
    }

    protected void buttonAction(){
        if (textMessage.getText().trim().length() > 0){
            textAreaMessage.append(name+" "+textMessage.getText()+"\n");  //Обновляем значение объекта
        } else{
        }
        textMessage.setText("");
        textMessage.requestFocusInWindow();
    }
}

