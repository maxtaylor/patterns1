package com.mt.patterns.mediator.counterparty;

import com.google.common.base.MoreObjects;
import com.mt.patterns.mediator.data.Stock;
import com.mt.patterns.mediator.mediator.Mediator;

/**
 * Created by max on 10/12/16.
 */
public interface CounterParty {
    public String getName();

    public void sell(Stock stock, int qty);

    public void buy(Stock stock, int qty);

    final class CounterpartyImpl implements CounterParty {

        private final Mediator mediator;
        private final String name;

        public CounterpartyImpl(Mediator mediator, String name) {
            this.mediator = mediator;
            this.name = name;
            this.mediator.addCounterparty(this);
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public final void sell(Stock stock, int qty) {
            this.mediator.sell(stock, qty, this);
        }

        @Override
        public final void buy(Stock stock, int qty) {
            this.mediator.buy(stock, qty, this);
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("name", getName())
                    .toString();
        }
    }
}