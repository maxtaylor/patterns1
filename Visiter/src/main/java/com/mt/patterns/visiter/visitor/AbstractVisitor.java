package com.mt.patterns.visiter.visitor;

import com.mt.patterns.visiter.products.Product;
import com.mt.patterns.visiter.products.ProductType;
import org.apache.log4j.Logger;

import java.math.BigDecimal;

/**
 * Created by max on 06/12/16.
 */
public abstract class AbstractVisitor implements TaxVisitor {

    private static final Logger LOG = Logger.getLogger(AbstractVisitor.class);

    private final BigDecimal ONE  = BigDecimal.ONE;
    private final BigDecimal ZERO = BigDecimal.ZERO;

    private final BigDecimal alcoholTax;
    private final BigDecimal tobaccoTax;
    private final BigDecimal dairyTax;
    private final BigDecimal fruitTax;
    private final BigDecimal vegTax;

    private final String description;

    protected AbstractVisitor(double alcoholTax, double tobaccoTax, double dairyTax, double fruitTax, double vegTax, String description) {
        this.alcoholTax     = ONE.add(new BigDecimal(alcoholTax));
        this.tobaccoTax     = ONE.add(new BigDecimal(tobaccoTax));
        this.dairyTax       = ONE.add(new BigDecimal(dairyTax));
        this.fruitTax       = ONE.add(new BigDecimal(fruitTax));
        this.vegTax         = ONE.add(new BigDecimal(vegTax));
        this.description    = description;
    }

    @Override
    public final BigDecimal visit(Product product) {

        final ProductType type = product.getType();
        LOG.info(String.format("Applying [%s] to product [%s]", description, product.getDescription()));

        switch (type) {
            case Alcohol:
                return alcoholTax.multiply(product.getPrice());
            case Tobacco:
                return tobaccoTax.multiply(product.getPrice());
            case Dairy:
                return dairyTax.multiply(product.getPrice());
            case Fruit:
                return fruitTax.multiply(product.getPrice());
            case Veg:
                return vegTax.multiply(product.getPrice());
            default:
                return ZERO;
        }
    }
}