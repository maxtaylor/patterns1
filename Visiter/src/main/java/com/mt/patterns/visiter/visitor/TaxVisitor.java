package com.mt.patterns.visiter.visitor;

import com.mt.patterns.visiter.products.Product;

import java.math.BigDecimal;

/**
 * Created by max on 06/12/16.
 */
public interface TaxVisitor {
    BigDecimal visit(Product product);
}
