package com.mycompany.ddroidd_nistorandreeamaria;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    private List<Product> products;
    private List<ShippingRate> rate;

    public Catalog() {
        addShippingRate();
        addList();
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<ShippingRate> getRate() {
        return rate;
    }

    public double getRateOfAProduct(Product product){
    double r=0;
    for(int i=0;i<products.size();i++)
    {
        if(product.equals(products.get(i)))
        {
           
           return product.getShippedFrom().getRate();
        }
    }
        return 0;
}
    public void addShippingRate() {
        rate = new ArrayList();
        ShippingRate country1 = new ShippingRate("RO", 1);
        ShippingRate country2 = new ShippingRate("UK", 2);
        ShippingRate country3 = new ShippingRate("US", 3);
        rate.add(country1);
        rate.add(country2);
        rate.add(country3);
    }

    public void addList() {
        products = new ArrayList();
        Product p1 = new Product("Mouse", 10.99, rate.get(0), 0.2);
        Product p2 = new Product("Keyboard", 40.99, rate.get(1), 0.7);
        Product p3 = new Product("Monitor", 164.99, rate.get(2), 1.9);
        Product p4 = new Product("Webcam", 84.99, rate.get(0), 0.2);
        Product p5 = new Product("Headphones", 59.99, rate.get(2), 0.6);
    

       Product p6 = new Product("Desk Lamp", 89.99, rate.get(1), 1.3);
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p6);

    }
    public Product searchProduct(String prod){
        for(int i=0;i<products.size();i++)
            if(prod.equals(products.get(i).getName())){
                return products.get(i);
            }
        return null;
    }
    
    public void displayProducts() {
        for(int i=0;i<products.size();i++)
            System.out.println(products.get(i));
    }

    
}
