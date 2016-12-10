package com.mt.patterns.decorator.decorator;

import com.mt.patterns.decorator.chart.Cart;
import com.mt.patterns.decorator.product.Category;
import com.mt.patterns.decorator.product.Product;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by max on 07/12/16.
 */
public interface Decorator {
    Map<Category, Comparable> getTotalForCategory();

    String getDescription();

    final class UsdDecorator implements Decorator {

        public static final double GBP_FX_RATE = 1.45;
        public final Cart cart;

        public UsdDecorator(Cart cart) {
            this.cart = cart;
        }

        @Override
        public Map<Category, Comparable> getTotalForCategory() {
            return Arrays.stream(Category.values())
                    .map(p -> new Product(p.name(), cart.getTotalForCategory(p) * GBP_FX_RATE, p))
                    .collect(Collectors.toMap(
                            p -> p.getCategory(),
                            p -> p.getPrice()));
        }

        @Override
        public String getDescription() {
            return String.format("Decorator computes product value in USD using rate [%s]", GBP_FX_RATE);
        }
    }


    final class PercentDecorator implements Decorator {
        private final Decorator childDecorator;

        public PercentDecorator(Decorator decorator) {
            this.childDecorator = decorator;
        }

        @Override
        public Map<Category, Comparable> getTotalForCategory() {
            final Map<Category, Comparable> mapOfPercentages = childDecorator.getTotalForCategory();
            final double sum = mapOfPercentages.values()
                    .stream()
                    .mapToDouble(e -> comparableToDouble(e))
                    .sum();

            return Arrays.stream(Category.values())
                    .collect(Collectors.toMap(c -> c, c -> comparableToDouble(mapOfPercentages.get(c)) / sum));
        }

        private Double comparableToDouble(Comparable comparable) {
            return Double.class.cast(comparable);
        }

        @Override
        public String getDescription() {
            return "Decorator computes percentages of the total spent for each category";
        }
    }

    final class HexDecorator implements Decorator {
        private final Decorator childDecorator;

        public HexDecorator(Decorator decorator) {
            this.childDecorator = decorator;
        }

        @Override
        public Map<Category, Comparable> getTotalForCategory() {
            return childDecorator.getTotalForCategory()
                    .entrySet()
                    .stream()
                    .collect(Collectors.toMap(
                            e -> e.getKey(),
                            e -> comparableToString(e.getValue())));
        }

        private String comparableToString(Comparable comparable) {
            return Double.toHexString(
                    BigDecimal.valueOf((Double) comparable)
                            .round(MathContext.DECIMAL32)
                            .doubleValue()
            );
        }

        @Override
        public String getDescription() {
            return "Decorator computes prices in HEX";// unlikely but possible
        }
    }
}