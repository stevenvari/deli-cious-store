package com.pluralsight.userInterface;

public interface Topping {

    String getName();
    double getPrice(String size, int itemExtra, String typeTopping);
}
