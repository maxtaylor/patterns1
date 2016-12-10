package com.mt.patterns.decorator.product;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.mt.patterns.decorator.product.Category.*;

/**
 * Created by max on 10/12/16.
 */
public final class Product {
    private final String name;
    private final double price;
    private final Category category;

    public Product(String name, double price, Category category) {
        Preconditions.checkNotNull(name, "Don't want no null name");
        Preconditions.checkNotNull(price, "Don't want no null price");
        Preconditions.checkNotNull(category, "Don't want no null category");
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

    //should be in a separate class
    public static final List<Product> listOfProducts = Collections.unmodifiableList(Arrays.asList(
            new Product("Beer", 9.99, Alcohol),
            new Product("Vodka", 12.99, Alcohol),
            new Product("Wine", 7.99, Alcohol),
            new Product("Baileys", 15.99, Alcohol),
            new Product("Cider", 5.49, Alcohol),

            new Product("Marlboro lights", 8.49, Tobacco),
            new Product("Camel", 9.99, Tobacco),
            new Product("LM", 7.99, Tobacco),
            new Product("Marlboro gold", 11.49, Tobacco),
            new Product("Parliament", 13.29, Tobacco),

            new Product("Banana", 0.89, Fruit),
            new Product("Apple", 1.09, Fruit),
            new Product("Pair", 0.69, Fruit),
            new Product("Grapes", 1.29, Fruit),
            new Product("Pineapple", 1.49, Fruit),

            new Product("Cucumber", 0.45, Veg),
            new Product("Tomato", 0.65, Veg),
            new Product("Potato", 0.29, Veg),
            new Product("Cabbage", 0.38, Veg),
            new Product("Salary", 0.87, Veg),

            new Product("Butter", 2.29, Dairy),
            new Product("Milk", 1.39, Dairy),
            new Product("Cheese", 4.49, Dairy),
            new Product("Cottage Cheese", 4.29, Dairy),
            new Product("Single Cream", 1.29, Dairy),

            new Product("Rump Steak", 7.49, Meat),
            new Product("Sausages", 4.39, Meat),
            new Product("Berger", 3.39, Meat),
            new Product("Chicken", 4.99, Meat),
            new Product("Fish", 7.39, Meat),

            new Product("Paracetamol", 0.27, Pharmacy),
            new Product("Tooth brush", 0.99, Pharmacy),
            new Product("Tooth paste", 1.12, Pharmacy),
            new Product("Vitamin C", 4.49, Pharmacy),
            new Product("Suncream", 3.99, Pharmacy)
            )
    );
}