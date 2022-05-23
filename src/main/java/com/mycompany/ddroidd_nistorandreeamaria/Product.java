package com.mycompany.ddroidd_nistorandreeamaria;

public class Product {

    private String name;
    private double itemPrice;
    private ShippingRate shippedFrom;
    private double weight;

    public Product() {

    }

    public Product(String name, double itemPrice, ShippingRate shippedFrom, double weight) {
        this.name = name;
        this.itemPrice = itemPrice;
        this.shippedFrom = shippedFrom;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public ShippingRate getShippedFrom() {
        return shippedFrom;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name + " - $" + itemPrice;
    }

}
