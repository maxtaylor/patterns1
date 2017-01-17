package com.mt.patterns.mediator.mediator;

import com.mt.patterns.mediator.counterparty.CounterParty;
import com.mt.patterns.mediator.data.Stock;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 10/12/16.
 */
public interface Mediator {

    public void buy(Stock stock, int qty, CounterParty counterpartyID);

    public void sell(Stock stock, int qty, CounterParty counterpartyID);

    public void addCounterparty(CounterParty counterparty);

    public final class MediatorImpl implements Mediator {

        private static final Logger LOG = Logger.getLogger(MediatorImpl.class);

        private final List<CounterParty> counterparties = new ArrayList<CounterParty>();
        private final List<Stock> stocksToBuy = new ArrayList<Stock>();
        private final List<Stock> stocksToSell = new ArrayList<Stock>();

        @Override
        public void buy(Stock stock, int qty, CounterParty counterPartyID) {
            if (stocksToSell.contains(stock)) {
                LOG.info("Stock {" + stock + "} has been bought by {" + counterPartyID + "}");
                stocksToSell.remove(stock);
            } else {
                this.stocksToBuy.add(stock);
                LOG.info("Could not find the right stock for " + stock);
            }
        }

        @Override
        public void sell(Stock stock, int qty, CounterParty counterpartyID) {
            if (stocksToBuy.contains(stock)) {
                LOG.info("Stock {" + stock + "} has been bought by {" + counterpartyID + "}");
                stocksToBuy.remove(stock);
            } else {
                this.stocksToSell.add(stock);
                LOG.info("Could not find the right stock for " + stock);
            }
        }

        @Override
        public void addCounterparty(CounterParty counterparty) {
            this.counterparties.add(counterparty);
            LOG.info("Adding counterpart : " + counterparty);
        }

    }

}
