package com.pluralsight.model;

import com.pluralsight.userInterFace.Topping;

public class RegularTopping implements Topping {

    private String name;
    private double price;

    public RegularTopping(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getPrice(String size, int itemExtra) {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
