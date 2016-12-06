package com.mt.patterns.visiter.visitor;

import com.mt.patterns.visiter.products.Product;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.mt.patterns.visiter.products.ProductType.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by max on 06/12/16.
 */
public class TaxVisitorTest {
    private static final Logger log = Logger.getLogger(TaxVisitorTest.class);

    private final TaxVisitor aus = new AuTaxVisitorImpl();
    private final TaxVisitor uk  = new UkTaxVisitorImpl();
    private final TaxVisitor uae = new UeTaxVisitorImpl();
    private final TaxVisitor usa = new UsTaxVisitorImpl();

    private final List<Product> products = Arrays.asList(
            new Product.ProductImpl("Fosters, Abda Nectar", BigDecimal.valueOf(12.49),Alcohol),
            new Product.ProductImpl("Baileys, Irish Cream", BigDecimal.valueOf(17.99),Alcohol),
            new Product.ProductImpl("Camel lights",         BigDecimal.valueOf(4.10), Tobacco),
            new Product.ProductImpl("Marlboro Gold",        BigDecimal.valueOf(5.50), Tobacco),
            new Product.ProductImpl("Tomatoes",             BigDecimal.valueOf(1.20), Veg),
            new Product.ProductImpl("Cucumbers",            BigDecimal.valueOf(1.12), Veg),
            new Product.ProductImpl("Apples",               BigDecimal.valueOf(1.75), Fruit),
            new Product.ProductImpl("Bananas",              BigDecimal.valueOf(0.80), Fruit),
            new Product.ProductImpl("Cottage Cheese",       BigDecimal.valueOf(2.99), Dairy),
            new Product.ProductImpl("Blue Stilton Cheese",  BigDecimal.valueOf(3.49), Dairy)
    );

    @BeforeClass
    public static void init() {
        BasicConfigurator.configure();
    }

    /**
     * Pricing basket of products as per UK tax
     */
    @Test
    public void testUkTaxVisitor() {
        final BigDecimal result = products.stream()
                .map(p -> uk.visit(p))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, BigDecimal.ROUND_HALF_UP);
        assertEquals("should match", BigDecimal.valueOf(142.82), result);
    }


    /**
     * Pricing basket of products as per UAE tax
     */
    @Test
    public void testUaeTaxVisitor() {
        final BigDecimal result = products.stream()
                .map(p -> uae.visit(p))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, BigDecimal.ROUND_HALF_UP);
        assertEquals("should match", BigDecimal.valueOf(61.12), result);
    }

    /**
     * Pricing basket of products as per USA tax
     */
    @Test
    public void testUsaTaxVisitor() {
        final BigDecimal result = products.stream()
                .map(p -> usa.visit(p))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, BigDecimal.ROUND_HALF_UP);
        assertEquals("should match", BigDecimal.valueOf(193.72), result);
    }

    /**
     * Pricing basket of products as per Australia tax
     */
    @Test
    public void testAustraliaTaxVisitor() {
        final BigDecimal result = products.stream()
                .map(p -> aus.visit(p))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, BigDecimal.ROUND_HALF_UP);
        assertEquals("should match", BigDecimal.valueOf(162.91), result);
    }
}
