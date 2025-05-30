package com.pluralsight.model;

public class Chips extends Order{


    private double price;

    public Chips( double price) {

        this.price = price;
    }


    public double getPrice(String choice) {
        if (choice.equalsIgnoreCase ("yes")){
            price += 1.50;
        }
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Chips{" +
                "price=" + price +
                '}';
    }
}
