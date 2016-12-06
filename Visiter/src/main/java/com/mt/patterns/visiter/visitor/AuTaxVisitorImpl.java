package com.mt.patterns.visiter.visitor;

/**
 * Created by max on 06/12/16.
 */
public final class AuTaxVisitorImpl extends AbstractVisitor implements TaxVisitor {
    public AuTaxVisitorImpl() {
        super(2.35, 3.25, 0.75, 0.77, 0.79, "Australia tax rates");
    }
}