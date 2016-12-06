package com.mt.patterns.visiter.visitor;

/**
 * Created by max on 06/12/16.
 */
public final class UkTaxVisitorImpl extends AbstractVisitor implements TaxVisitor {

    public UkTaxVisitorImpl() {
        super(1.50, 4.50, 0.20, 0.25, 0.23, "UK tax rates");
    }
}
