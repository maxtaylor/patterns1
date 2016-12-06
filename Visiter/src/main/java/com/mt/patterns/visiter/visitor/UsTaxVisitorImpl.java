package com.mt.patterns.visiter.visitor;

/**
 * Created by max on 06/12/16.
 */
public final class UsTaxVisitorImpl extends AbstractVisitor implements TaxVisitor {
    public UsTaxVisitorImpl() {
        super(3.00, 4.75, 0.45, 0.47, 0.49, "USA tax rates");
    }
}