package com.mt.patterns.mediator.data;

import com.google.common.base.MoreObjects;

/**
 * Created by max on 10/12/16.
 */
public final class Stock {
    private final String name;
    private final int price;

    public Stock(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("price", price)
                .toString();
    }
}
