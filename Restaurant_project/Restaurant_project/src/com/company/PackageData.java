package com.company;

import java.io.*;
import java.util.ArrayList;
public class PackageData implements Serializable {
    String operationType;
    ArrayList<Orders> orders;
    ArrayList<Foods> foods;
    ArrayList<AdminData> admins;
    ArrayList<BuyerData> buyers;
    AdminData admin;
    BuyerData buyer;
    Orders order;
    Foods food;
    Long id;

    public PackageData(){}

    public PackageData(String operationType, ArrayList<Orders> orders, ArrayList<Foods> foods, ArrayList<AdminData> admins, ArrayList<BuyerData> buyers, AdminData admin, BuyerData buyer, Orders order, Foods food, Long id) {
        this.operationType = operationType;
        this.orders = orders;
        this.foods = foods;
        this.admins = admins;
        this.buyers = buyers;
        this.admin = admin;
        this.buyer = buyer;
        this.order = order;
        this.food = food;
        this.id = id;
    }

    public String getOperationType() {
        return operationType;
    }

    public ArrayList<Orders> getOrders() {
        return orders;
    }

    public ArrayList<Foods> getFoods() {
        return foods;
    }

    public ArrayList<AdminData> getAdmins() {
        return admins;
    }

    public ArrayList<BuyerData> getBuyers() {
        return buyers;
    }

    public AdminData getAdmin() {
        return admin;
    }

    public BuyerData getBuyer() {
        return buyer;
    }

    public Orders getOrder() {
        return order;
    }

    public Foods getFood() {
        return food;
    }

    public Long getId() {
        return id;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public void setOrders(ArrayList<Orders> orders) {
        this.orders = orders;
    }

    public void setFoods(ArrayList<Foods> foods) {
        this.foods = foods;
    }

    public void setAdmins(ArrayList<AdminData> admins) {
        this.admins = admins;
    }

    public void setBuyers(ArrayList<BuyerData> buyers) {
        this.buyers = buyers;
    }

    public void setAdmin(AdminData admin) {
        this.admin = admin;
    }

    public void setBuyer(BuyerData buyer) {
        this.buyer = buyer;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public void setFood(Foods food) {
        this.food = food;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PackageData{" +
                "operationType='" + operationType + '\'' +
                ", orders=" + orders +
                ", foods=" + foods +
                ", admins=" + admins +
                ", buyers=" + buyers +
                ", admin=" + admin +
                ", buyer=" + buyer +
                ", order=" + order +
                ", food=" + food +
                ", id=" + id +
                '}';
    }
}

