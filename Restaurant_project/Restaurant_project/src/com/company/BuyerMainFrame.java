package com.company;

import javax.swing.*;
public class BuyerMainFrame extends JFrame {
    public BuyerAddPage addOrders;
    public BuyerListPage listOrders;
    public BuyerMainMenu menu;
    public BuyerRegistr regitr;
    public BuyerAdd addBuyer;
    public Welcome2 welcome2;

    public BuyerMainFrame(){
        setTitle("BUYER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        setLayout(null);
        setLocationRelativeTo(null);
        menu = new BuyerMainMenu();
        menu.setLocation(0,0);
        menu.setVisible(false);
        add(menu);

        addBuyer = new BuyerAdd();
        addBuyer.setLocation(0, 0);
        addBuyer.setVisible(false);
        add(addBuyer);

        welcome2 = new Welcome2();
        welcome2.setLocation(0, 0);
        welcome2.setVisible(true);
        add(welcome2);

        regitr=new BuyerRegistr();
        regitr.setLocation(0,0);
        regitr.setVisible(false);
        add(regitr);

        addOrders = new BuyerAddPage();
        addOrders.setLocation(0,0);
        addOrders.setVisible(false);
        add(addOrders);

        listOrders= new BuyerListPage();
        listOrders.setLocation(0,0);
        listOrders.setVisible(false);
        add(listOrders);

        repaint();
    }
}
