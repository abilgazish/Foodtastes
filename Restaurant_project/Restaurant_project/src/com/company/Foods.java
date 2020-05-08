package com.company;

import java.io.Serializable;

public class Foods  implements Serializable {
    private Long id;
    private String kindoffood;
    private String name;
    private int price;

    public Foods(){}

    public Foods(Long id, String kindoffood, String name, int price) {
        this.id = id;
        this.kindoffood = kindoffood;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKindoffood() {
        return kindoffood;
    }

    public void setKindoffood(String kindoffood) {
        this.kindoffood = kindoffood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Foods{" +
                "id=" + id +
                ", kindoffood='" + kindoffood + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
