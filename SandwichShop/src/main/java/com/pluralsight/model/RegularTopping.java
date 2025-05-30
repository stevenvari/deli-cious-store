package com.pluralsight.model;

import com.pluralsight.userInterface.Topping;

public class RegularTopping implements Topping {

    private String name;


    public RegularTopping(String name) {
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
    public double getPrice(String size, int itemExtra, String typeTopping) {
        return 0;
    }
}
