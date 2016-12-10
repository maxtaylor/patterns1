package com.mt.patterns.decorator.cart;

import com.google.common.base.Preconditions;
import com.mt.patterns.decorator.product.Category;
import com.mt.patterns.decorator.product.Product;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by max on 10/12/16.
 */
public interface Cart {
    double getTotalForCategory(Category category);

    void addProduct(Product product);

    double getTotalCartCost();

    final class CartImpl implements Cart {
        private static final Logger LOG = Logger.getLogger(CartImpl.class);
        private final List<Product> products = new ArrayList<>();

        @Override
        public double getTotalForCategory(Category category) {
            Preconditions.checkNotNull(category, "Dont want no null category");
            LOG.info("Computing total for category " + category);
            return products.stream()
                    .filter(p -> category.equals(p.getCategory()))
                    .map(p -> p.getPrice())
                    .mapToDouble(Double::doubleValue)
                    .sum();
        }

        @Override
        public void addProduct(Product product) {
            Preconditions.checkNotNull(product, "Dont want no null products");
            products.add(product);
        }

        @Override
        public double getTotalCartCost() {
            LOG.info("Computing total for cart");
            return products.stream()
                    .map(p -> p.getPrice())
                    .mapToDouble(Double::doubleValue)
                    .sum();
        }
    }
}
