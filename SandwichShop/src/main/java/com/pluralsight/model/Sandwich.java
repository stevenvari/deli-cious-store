package com.pluralsight.model;

import com.pluralsight.userInterFace.Topping;

import java.util.List;

public class Sandwich {

    private String size;
    private String breadType;
    private boolean toasted;
    private List<Topping> toppings;

    public Sandwich(String size, String breadType, boolean toasted, List<Topping> toppings) {
        this.size = size;
        this.breadType = breadType;
        this.toasted = toasted;
        this.toppings = toppings;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public double getPrice() {
        double price = 0.0;

        if (size.equals("4\"")) {
            price += 5.50;
        } else if (size.equals("8\"")) {
            price += 7.00;
        } else if (size.equals("12\"")) {
            price += 8.50;
        }
        return price;
    }

    public void showDetails() {

        System.out.println("Sandwich " + size + " on " + breadType + (toasted? " (Toasted)" : ""));
        System.out.println("Toppings: ");
        for (Topping topping : toppings){
            System.out.println("- " + topping.getName());
        }
        System.out.println("Total: $" + getPrice());
    }
}
