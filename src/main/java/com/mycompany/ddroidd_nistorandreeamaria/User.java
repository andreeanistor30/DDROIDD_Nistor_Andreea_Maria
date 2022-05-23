package com.mycompany.ddroidd_nistorandreeamaria;

import java.util.Scanner;

public class User {

    private Catalog catalog;
    private ShoppingCart shCart;

    public User() {
        catalog = new Catalog();
        shCart = new ShoppingCart(catalog);
    }

    public void userChoice() {
        boolean stop = false;
        while (stop == false) {
            System.out.println("Add a product in shop cart");
            Scanner scanner = new Scanner(System.in);
            String product = scanner.nextLine();
            if (product.equals("stop")) {
                stop = true;
            }
            if (catalog.searchProduct(product) != null) {

                shCart.addProduct(catalog.searchProduct(product));
                shCart.display();
            } else if (!"stop".equals(product)) {
                System.out.println("This product doesn't exist");
            }

        }
        shCart.invoice();
    }

}
