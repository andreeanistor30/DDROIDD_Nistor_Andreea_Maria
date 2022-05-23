package Test;

import com.mycompany.ddroidd_nistorandreeamaria.Catalog;
import com.mycompany.ddroidd_nistorandreeamaria.Product;
import com.mycompany.ddroidd_nistorandreeamaria.ShippingRate;
import com.mycompany.ddroidd_nistorandreeamaria.ShoppingCart;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Test {

    @Test
    public void testDisplayProduct() {
        ShippingRate country1 = new ShippingRate("RO", 1);
        Product p1 = new Product("Mouse", 10.99, country1, 0.2);
        assertEquals("Should display Mouse - $10.99", "Mouse - $10.99", p1.toString());
    }

    @Test
    public void testInvoiceProduct1() {
        Catalog catalog = new Catalog();
        Product p1 = catalog.searchProduct("Mouse");
        Product p2 = catalog.searchProduct("Monitor");
        ShoppingCart sh = new ShoppingCart(catalog);
        sh.addProduct(p1);
        sh.addProduct(p2);
        sh.addProduct(p2);
        sh.invoice();

        assertEquals(340.97, sh.getSubtotal(), 0.0);
        assertEquals(116, sh.getShipping(), 0.0);
        assertEquals(456.97, sh.getTotal(), 0.0);

    }

    @Test
    public void testInvoiceProduct2() {
        Catalog catalog = new Catalog();
        Product p1= catalog.searchProduct("Monitor");
        ShoppingCart sh = new ShoppingCart(catalog);
        sh.addProduct(p1);
        sh.invoice();

        assertEquals(164.99, sh.getSubtotal(), 0.0);
        assertEquals(57, sh.getShipping(), 0.0);
        assertEquals(221.99, sh.getTotal(), 0.0);

    }
}
