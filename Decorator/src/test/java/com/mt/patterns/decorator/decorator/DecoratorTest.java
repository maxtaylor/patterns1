package com.mt.patterns.decorator.decorator;

import com.mt.patterns.decorator.cart.Cart;
import com.mt.patterns.decorator.product.Category;
import com.mt.patterns.decorator.product.Product;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

import static com.mt.patterns.decorator.product.Category.*;
import static org.junit.Assert.assertEquals;


/**
 * Created by root on 10/12/16.
 */
public class DecoratorTest {

    private static final Logger LOG = Logger.getLogger(DecoratorTest.class);

    private static Double fxRate = Decorator.UsdDecorator.GBP_FX_RATE;

    private static final Cart cart = new Cart.CartImpl();
    private static final Decorator usdDecorator = new Decorator.UsdDecorator(cart);
    //the other 2 can have CART directly, or underlying decorator to achieve combined effect.
    private static final Decorator percentDecorator = new Decorator.PercentDecorator(usdDecorator);
    private static final Decorator hexDecorator = new Decorator.HexDecorator(percentDecorator);


    @BeforeClass
    public static void init() {
        BasicConfigurator.configure();
        Product.listOfProducts.stream().forEach(p -> cart.addProduct(p));
    }

    /**
     * Test that usd prices are calculated correctly
     */
    @Test
    public void testUsdDecorator() {
        LOG.info(usdDecorator.getDescription());
        final Map<Category, Double> mapOfPrices = Map.class.cast(usdDecorator.getTotalForCategory());
        final double totalCartValue = mapOfPrices.values()
                .stream()
                .mapToDouble(Double::doubleValue)
                .sum();

        assertEquals("Total price is wrong", cart.getTotalCartCost() * fxRate, totalCartValue, 0.000_001);
        for (Category category : mapOfPrices.keySet()) {
            assertEquals(String.format("Wrong prices for category [%s]", category),
                    cart.getTotalForCategory(category) * fxRate,
                    mapOfPrices.get(category),
                    0);
        }
    }

    /**
     * Test that percentages are calculated correctly
     */
    @Test
    public void testPercentDecorator() {
        LOG.info(percentDecorator.getDescription());
        final Map<Category, Double> mapOfPrices = Map.class.cast(percentDecorator.getTotalForCategory());
        final double sum = mapOfPrices.values()
                .stream()
                .mapToDouble(Double::doubleValue)
                .sum();
        assertEquals("Should add up to 100% give or take 2%", 100, 100 * sum, 0.00001);
    }

    /**
     * Test that hex percentages are calculated correctly
     */
    @Test
    public void testHexDecorator() {
        LOG.info(hexDecorator.getDescription());
        final Map<Category, String> mapOfPrices = Map.class.cast(hexDecorator.getTotalForCategory());
        assertEquals("Alcohol", "0x1.476493278f91p-2", mapOfPrices.get(Alcohol));
        assertEquals("Dairy",   "0x1.574f5a055a07p-4", mapOfPrices.get(Dairy));
        assertEquals("Fruit",   "0x1.1026b3f3e2e64p-5", mapOfPrices.get(Fruit));
        assertEquals("Meat",    "0x1.592ec006ebac9p-3", mapOfPrices.get(Meat));
        assertEquals("Pharmacy","0x1.0f270755dfb08p-4", mapOfPrices.get(Pharmacy));
        assertEquals("Tobacco", "0x1.3fe70b3c74249p-2", mapOfPrices.get(Tobacco));
    }
}