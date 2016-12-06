package com.mt.patterns.visiter.products;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

import java.math.BigDecimal;

/**
 * Created by max on 06/12/16.
 */
public interface Product {

    String getDescription();
    BigDecimal getPrice();
    ProductType getType();

    final class ProductImpl implements Product {

        private final String description;
        private final BigDecimal price;
        private final ProductType type;

        public ProductImpl(String description, BigDecimal price, ProductType type) {

            Preconditions.checkNotNull(description, "description is null");
            Preconditions.checkNotNull(price, "price is null");
            Preconditions.checkNotNull(type, "type is null");

            this.description = description;
            this.price = price;
            this.type = type;
        }

        @Override
        public String getDescription() {
            return description;
        }

        @Override
        public BigDecimal getPrice() {
            return price;
        }

        @Override
        public ProductType getType() {
            return type;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("description", description)
                    .add("price", price)
                    .add("type", type)
                    .toString();
        }
    }
}
