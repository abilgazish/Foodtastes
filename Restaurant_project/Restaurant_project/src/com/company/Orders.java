package com.company;

import java.io.Serializable;

public class Orders implements Serializable {
    private Long id;
    private int foodsId;
    private String name;
    private String surname;
    private String passwordNumber;

    public Orders(){}

    public Orders(Long id, int foodsId, String name, String surname, String passwordNumber) {
        this.id = id;
        this.foodsId = foodsId;
        this.name = name;
        this.surname = surname;
        this.passwordNumber = passwordNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFoodsId() {
        return foodsId;
    }

    public void setFoodsId(int foodsId) {
        this.foodsId = foodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPasswordNumber() {
        return passwordNumber;
    }

    public void setPasswordNumber(String passwordNumber) {
        this.passwordNumber = passwordNumber;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", foodsId=" + foodsId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", passwordNumber=" + passwordNumber +
                '}';
    }
}

