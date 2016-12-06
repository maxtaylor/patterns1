package com.mt.patterns.visiter.visitor;

/**
 * Created by max on 06/12/16.
 */
public final class UeTaxVisitorImpl extends AbstractVisitor implements TaxVisitor {

    public UeTaxVisitorImpl() {
        super(0.15, 0.40, 0.10, 0.12, 0.14, "UAE tax rates");
    }
}