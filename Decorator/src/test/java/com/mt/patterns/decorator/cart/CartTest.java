package com.mt.patterns.decorator.cart;

import com.mt.patterns.decorator.product.Product;
import org.apache.log4j.BasicConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.mt.patterns.decorator.product.Category.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by root on 10/12/16.
 */
public class CartTest {
    private static final Cart cart = new Cart.CartImpl();

    @BeforeClass
    public static void init() {
        BasicConfigurator.configure();
        Product.listOfProducts.stream().forEach(p -> cart.addProduct(p));
    }

    @Test
    public void testCart() {
        assertEquals("Alcohol", 52.45, cart.getTotalForCategory(Alcohol), 0);
        assertEquals("Dairy", 13.75, cart.getTotalForCategory(Dairy), 0);
        assertEquals("Fruit", 5.45, cart.getTotalForCategory(Fruit), 0);
        assertEquals("Meat", 27.65, cart.getTotalForCategory(Meat), 0);
        assertEquals("Pharmacy", 10.86, cart.getTotalForCategory(Pharmacy), 0);
        assertEquals("Tobacco", 51.25, cart.getTotalForCategory(Tobacco), 0);
    }
}
