package com.pluralsight.model;

import com.pluralsight.userInterFace.Topping;

public class PremiumTopping implements Topping {

    private String name;

    public PremiumTopping(String name) {
        this.name = name;
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
        return 0;
    }
}
