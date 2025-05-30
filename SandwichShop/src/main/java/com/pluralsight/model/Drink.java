package com.pluralsight.model;

public class Drink extends Order {

    private String flavor;
    private double price;
    private String size;

    public Drink(String flavor, double price, String size) {
        this.flavor = flavor;
        this.price = price;
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public double getPrice() {
        if (size.equalsIgnoreCase("small")){
            price += 2.00;
        } else if (size.equalsIgnoreCase("medium")) {
            price += 2.50;
        } else if (size.equalsIgnoreCase("Large")) {
            price += 3.00;
        }

        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "flavor='" + flavor + '\'' +
                ", price=" + price +
                ", size='" + size + '\'' +
                '}';

    }
}
