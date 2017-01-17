package com.mt.mediator.mediator;

import com.google.common.collect.ImmutableMap;
import com.mt.patterns.mediator.counterparty.CounterParty;
import com.mt.patterns.mediator.data.Stock;
import com.mt.patterns.mediator.mediator.Mediator;
import org.apache.log4j.BasicConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by root on 10/12/16.
 */
public class MediatorTest {

    private final Map<String, Stock> mapOfStocks = ImmutableMap.of(
            "GOOG", new Stock("GOOG", 500),
            "MSFT", new Stock("MSFT", 50),
            "AAPL", new Stock("AAPL", 125),
            "FB", new Stock("FB", 86)
    );


    private final Mediator lse = new Mediator.MediatorImpl();
    private final CounterParty jpm = new CounterParty.CounterpartyImpl(lse, "JPM");
    private final CounterParty gs = new CounterParty.CounterpartyImpl(lse, "GS");

    @BeforeClass
    public static void init() {
        BasicConfigurator.configure();
    }

    @Test
    public void textX() {
        jpm.buy(mapOfStocks.get("GOOG"), 10);
        gs.sell(mapOfStocks.get("MSFT"), 20);
        jpm.sell(mapOfStocks.get("FB"), 30);
        gs.buy(mapOfStocks.get("AAPL"), 40);
        gs.sell(mapOfStocks.get("GOOG"), 50);
        jpm.buy(mapOfStocks.get("MSFT"), 60);
        assertEquals("", 0, 0);


    }

}
