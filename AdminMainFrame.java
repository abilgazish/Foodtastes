package com.company;

import javax.swing.*;
public class AdminMainFrame  extends JFrame {
    public AdminAddPage addFoods;
    public AdminListPage list;
    public AdminDeletePage deletePage;
    public AdminMainMenu menu;
    public AdminRegistr regitr;
    public AdminAdd addAdmin;
    public Welcome welcome;
    public AdminMainFrame(){
        setTitle("ADMIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        setLayout(null);
        setLocationRelativeTo(null);

        welcome = new Welcome();
        welcome.setLocation(0, 0);
        welcome.setVisible(true);
        add(welcome);

        menu = new AdminMainMenu();
        menu.setLocation(0,0);
        menu.setVisible(false);
        add(menu);

        addAdmin = new AdminAdd();
        addAdmin.setLocation(0, 0);
        addAdmin.setVisible(false);
        add(addAdmin);

        regitr=new AdminRegistr();
        regitr.setLocation(0,0);
        regitr.setVisible(false);
        add(regitr);

        addFoods = new AdminAddPage();
        addFoods.setLocation(0,0);
        addFoods.setVisible(false);
        add(addFoods);

        list = new AdminListPage();
        list.setLocation(0,0);
        list.setVisible(false);
        add(list);

        deletePage=new AdminDeletePage();
        deletePage.setLocation(0,0);
        deletePage.setVisible(false);
        add(deletePage);

        repaint();
    }
}

