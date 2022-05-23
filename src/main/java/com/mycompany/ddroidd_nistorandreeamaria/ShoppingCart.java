package com.mycompany.ddroidd_nistorandreeamaria;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ShoppingCart {

    
    private Map<Product, Integer> cart;
    private Catalog catalog;
    private double subtotal = 0;
    private double shipping = 0;
    private double total = 0;
    public ShoppingCart(Catalog catalog) {
        cart = new HashMap();
        this.catalog = catalog;
    }

    public double getShipping() {
        return shipping;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTotal() {
        return total;
    }
    
    public void addProduct(Product product) {
        for (Product p : cart.keySet()) {
            if (product.equals(p)) {
                cart.put(product, cart.get(product) + 1);
                return;
            }
        }
        cart.put(product, 1);
    }

    public void display() {
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey().getName() + " x " + entry.getValue());
        }
    }

    public void invoice() {
        
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            subtotal += entry.getKey().getItemPrice() * entry.getValue();
            shipping += Math.round((entry.getKey().getWeight() / 0.1 * catalog.getRateOfAProduct(entry.getKey())) * entry.getValue());
        }
        total = subtotal + shipping;
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Shipping: $" + shipping);
        System.out.println("Total: $" + total);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.cart);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ShoppingCart other = (ShoppingCart) obj;
        return Objects.equals(this.cart, other.cart);
    }

}
