package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AdminAddPage extends Container {
    private JLabel labelkindoffood;
    private JTextField textkindoffood;

    private JLabel labelname;
    private JTextField textname;

    private JLabel labelPrice;
    private JTextField textPrice;

    private JButton addFoods;
    private JButton back;

    public AdminAddPage() {
        setLayout(null);
        setSize(700, 700);

        labelkindoffood = new JLabel("KindofFood:");
        labelkindoffood.setBounds(250, 150, 80, 40);
        add(labelkindoffood);
        textkindoffood = new JTextField();
        textkindoffood.setBounds(340, 150, 100, 40);
        add(textkindoffood);

        labelname = new JLabel("Name:");

        labelname.setBounds(250, 300, 80, 40);
        add(labelname);

        textname = new JTextField();
        textname.setBounds(340, 300, 100, 40);
        add(textname);

        labelPrice = new JLabel("Price:");
        labelPrice.setBounds(250, 350, 80, 40);
        add(labelPrice);

        textPrice = new JTextField();
        textPrice.setBounds(340, 350, 100, 40);
        add(textPrice);

        addFoods = new JButton("Add");
        addFoods.setBounds(250, 400, 100, 50);
        addFoods.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int price = 0;

                try {
                    price = Integer.parseInt(textPrice.getText());
                    Foods foods = new Foods(null, textkindoffood.getText(), textname.getText(), price);
                    Admin.addFoods(foods);

                    textkindoffood.setText("");
                    textname.setText("");
                    textPrice.setText("");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(addFoods);

        back = new JButton("Back");
        back.setBounds(360, 400, 100, 50);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Admin.showMenuPage();
            }
        });
        add(back);
    }
}

