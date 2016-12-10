package com.mt.patterns.decorator.product;

import com.google.common.base.MoreObjects;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by max on 10/12/16.
 */
public final class Product {
    private final String name;
    private final double price;
    private final Category category;

    public Product(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", getName())
                .add("price", getPrice())
                .add("category", getCategory())
                .toString();
    }

    public static final List<Product> listOfProducts = Collections.unmodifiableList(Arrays.asList(
            new Product("Beer", 9.99, Category.Alcohol),
            new Product("Vodka", 12.99, Category.Alcohol),
            new Product("Wine", 7.99, Category.Alcohol),
            new Product("Baileys", 15.99, Category.Alcohol),
            new Product("Cider", 5.49, Category.Alcohol),

            new Product("Marlboro lights", 8.49, Category.Tobacco),
            new Product("Camel", 9.99, Category.Tobacco),
            new Product("LM", 7.99, Category.Tobacco),
            new Product("Marlboro gold", 11.49, Category.Tobacco),
            new Product("Parliament", 13.29, Category.Tobacco),

            new Product("Banana", 0.89, Category.Fruit),
            new Product("Apple", 1.09, Category.Fruit),
            new Product("Pair", 0.69, Category.Fruit),
            new Product("Grapes", 1.29, Category.Fruit),
            new Product("Pineapple", 1.49, Category.Fruit),

            new Product("Cucumber", 0.45, Category.Veg),
            new Product("Tomato", 0.65, Category.Veg),
            new Product("Potato", 0.29, Category.Veg),
            new Product("Cabbage", 0.38, Category.Veg),
            new Product("Salary", 0.87, Category.Veg),

            new Product("Butter", 2.29, Category.Dairy),
            new Product("Milk", 1.39, Category.Dairy),
            new Product("Cheese", 4.49, Category.Dairy),
            new Product("Cottage Cheese", 4.29, Category.Dairy),
            new Product("Single Cream", 1.29, Category.Dairy),

            new Product("Rump Steak", 7.49, Category.Meat),
            new Product("Sausages", 4.39, Category.Meat),
            new Product("Berger", 3.39, Category.Meat),
            new Product("Chicken", 4.99, Category.Meat),
            new Product("Fish", 7.39, Category.Meat),

            new Product("Paracetamol", 0.27, Category.Pharmacy),
            new Product("Tooth brush", 0.99, Category.Pharmacy),
            new Product("Tooth paste", 1.12, Category.Pharmacy),
            new Product("Vitamin C", 4.49, Category.Pharmacy),
            new Product("Suncream", 3.99, Category.Pharmacy)
            )
    );
}