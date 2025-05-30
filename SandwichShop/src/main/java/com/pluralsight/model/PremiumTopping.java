package com.pluralsight.model;

import com.pluralsight.userInterface.Topping;

public class PremiumTopping implements Topping {

    private String name;
    private double price;
    private String typePremiumTopping;

    public PremiumTopping(String name, double price, String typePremiumTopping) {
        this.name = name;
        this.price = price;
        this.typePremiumTopping = typePremiumTopping;
    }

    public String getTypePremiumTopping() {
        return typePremiumTopping;
    }

    public void setTypePremiumTopping(String typePremiumTopping) {
        this.typePremiumTopping = typePremiumTopping;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice(String size, int itemExtra, String typeTopping) {
        double price = 0.0;

        if (size.equals("4")) {
            if (typeTopping.equalsIgnoreCase("meat")){
                price += 1.00;
                if (itemExtra > 0){
                    for (int i = 0; i < itemExtra; i++) {
                        price += 0.50;
                    }
                }
            } else if (typeTopping.equalsIgnoreCase("cheese")) {
                price += 0.75;
                if (itemExtra > 0){
                    for (int i = 0; i < itemExtra; i++) {
                        price += 0.30;
                    }
                }
            }
        } else if (size.equals("8")) {
            if (typeTopping.equalsIgnoreCase("meat")){
                price += 2.00;
                if (itemExtra > 0){
                    for (int i = 0; i < itemExtra; i++) {
                        price += 1.00;
                    }
                }
            } else if (typeTopping.equalsIgnoreCase("cheese")) {
                price += 1.50;
                if (itemExtra > 0) {
                    for (int i = 0; i < itemExtra; i++) {
                       price += 0.60;
                    }
                }
            }
        } else if (size.equals("12")) {
            if (typeTopping.equalsIgnoreCase("meat")){
                price += 3.00;
                if (itemExtra > 0){
                    for (int i = 0; i < itemExtra; i++) {
                        price += 1.50;
                    }
                }
            } else if (typeTopping.equalsIgnoreCase("cheese")) {
                price += 2.25;
                if (itemExtra > 0){
                    for (int i = 0; i < itemExtra; i++) {
                        price += 0.90;
                    }
                }
            }
        }
        return price;
    }
}
