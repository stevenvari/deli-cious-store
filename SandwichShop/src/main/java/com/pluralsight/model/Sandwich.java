package com.pluralsight.model;

import com.pluralsight.userInterface.Topping;

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

    public Sandwich() {
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

        if (size.equals("4")) {
            price += 5.50;
        } else if (size.equals("8")) {
            price += 7.00;
        } else if (size.equals("12")) {
            price += 8.50;
        }
        return price;
    }

    public String showDetails() {
        StringBuilder builder = new StringBuilder();

        System.out.println("Sandwich " + size + "\" on " + breadType + " bread" + (toasted ? " (Toasted)" : ""));
        builder.append("Sandwich " + size + "\" on " + breadType + " bread" + (toasted ? " (Toasted)" : "") + "\n");
        System.out.println("Toppings: ");
        builder.append("Toppings: " + "\n");
        for (Topping topping : toppings){
            System.out.println("- " + topping.getName());
            builder.append("- " + topping.getName() + "\n");
        }
        System.out.println("Sandwich: $" + getPrice());
        builder.append("Sandwich: $" + getPrice() + "\n");

        return builder.toString();
    }

}
