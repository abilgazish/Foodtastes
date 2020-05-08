package com.company;

import java.io.*;
import java.net.*;
import java.util.*;
public class Admin {
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    public static  Socket socket;
    public static AdminMainFrame frame;
    public static String accaunt=null;

    private static  ArrayList<AdminData> admins;

    public static void myLogin(String login){ accaunt=login; }

    public static void connectToServer(){
        try {
            socket=new Socket("127.0.0.1",7999);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        }catch (Exception e){e.printStackTrace();}
    }

    public static void addFoods(Foods foods){
        PackageData pd=new PackageData();
        pd.setOperationType("Add_Food");
        pd.setFood(foods);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){e.printStackTrace();}
    }

    public static ArrayList<Foods> listFoods(){
        ArrayList<Foods> foods=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setOperationType("List_Foods");
        pd.setFoods(foods);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                foods=pd.getFoods();
            }
        }catch (Exception e){e.printStackTrace();}
        return foods;
    }

    public static void deleteWithId(Long id){
        PackageData pd=new PackageData();
        pd.setOperationType("Delete_Foods");
        pd.setId(id);
        ArrayList<Foods> foods=pd.getFoods();
        try {
            outputStream.writeObject(pd);
        }catch(Exception e){e.printStackTrace();}
    }

    public static ArrayList<AdminData> listAdmin(){
        ArrayList<AdminData> admins=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setOperationType("List_Admins");
        pd.setAdmins(admins);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                admins=pd.getAdmins();
                for(AdminData ad : admins)
                    System.out.println(ad);
            }
        }catch (Exception e){e.printStackTrace();}
        return admins;
    }

    public static void addAdmin(AdminData admin){
        PackageData pd=new PackageData();
        pd.setOperationType("Add_Admin");
        pd.setAdmin(admin);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){e.printStackTrace();}
    }

    public static void showAddPage(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.list.setVisible(false);
        Admin.frame.deletePage.setVisible(false);
        Admin.frame.addFoods.setVisible(true);
        Admin.frame.repaint();
    }

    public static void showRegistrPage(){
        Admin.frame.addAdmin.setVisible(false);
        Admin.frame.regitr.setVisible(true);
        Admin.frame.menu.setVisible(false);
        Admin.frame.repaint();
    }

    public static void showListPage(){
        frame.menu.setVisible(false);
        frame.addFoods.setVisible(false);
        frame.deletePage.setVisible(false);
        frame.list.setVisible(true);
        ArrayList<Foods> list = listFoods();
        Admin.frame.list.updateArea(list);
    }

    public static void showDeletePage(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.addFoods.setVisible(false);
        Admin.frame.list.setVisible(false);;
        ArrayList<Foods> list=listFoods();
        frame.deletePage.updateArea(list);
        Admin.frame.deletePage.setVisible(true);
        Admin.frame.repaint();
    }

    public static void showMainMenu() {
        Admin.frame.addAdmin.setVisible(false);
        Admin.frame.regitr.setVisible(false);
        Admin.frame.menu.setVisible(true);
        Admin.frame.repaint();
    }


    public static void showMenuPage(){
        Admin.frame.addFoods.setVisible(false);
        Admin.frame.list.setVisible(false);
        Admin.frame.deletePage.setVisible(false);
        Admin.frame.menu.setVisible(true);
        Admin.frame.repaint();
    }

    public static void MenuPage(){
        Admin.frame.addFoods.setVisible(false);
        Admin.frame.list.setVisible(false);
        Admin.frame.deletePage.setVisible(false);
        Admin.frame.menu.setVisible(false);
        Admin.frame.regitr.setVisible(false);
        Admin.frame.welcome.setVisible(false);
        Admin.frame.addAdmin.setVisible(true);
        Admin.frame.repaint();
    }


    public static void main(String[] args){
        connectToServer();

        frame = new AdminMainFrame();
        frame.setVisible(true);
    }
}

