package com.mt.patterns.chain.of.responsibility.handler;

import com.mt.patterns.chain.of.responsibility.data.Request;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;

/**
 * Created by root on 06/12/16.
 */
public class ChainTest {

    private static final Logger log = Logger.getLogger(ChainTest.class);

    private final BigDecimal ZERO   = BigDecimal.ZERO;
    private final BigDecimal ONE    = BigDecimal.ONE;
    private final BigDecimal TEN    = BigDecimal.TEN;
    private final BigDecimal PI     = BigDecimal.valueOf(Math.PI);
    private final BigDecimal E      = BigDecimal.valueOf(Math.E);

    private final Request addRequest        = Request.newAddRequest(ZERO, ONE);
    private final Request subtractRequest   = Request.newSubtractRequest(ZERO, ONE);
    private final Request divideRequest     = Request.newDivideRequest(ONE, TEN);
    private final Request multiplyRequest   = Request.newMultiplyRequest(PI, E);
    private final Request unknownRequest    = Request.newUnknownRequest();

    private final Chain chain = new Chain.ChainImpl();

    @BeforeClass
    public static void init() {
        BasicConfigurator.configure();
    }

    /**
     * testing unknown request, expecting exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void testUnknownRequest() {
        log.info(String.format("Testing request [%s]", unknownRequest));
        chain.processRequest(unknownRequest);
    }

    /**
     * testing add request, expecting right result
     */
    @Test
    public void testAddRequest() {
        log.info(String.format("Testing request [%s]", addRequest));
        final BigDecimal result = addRequest.getFirst()
                .add(addRequest.getSecond())
                .setScale(4, RoundingMode.HALF_UP);
        assertEquals("Should add", result, chain.processRequest(addRequest));
    }


    /**
     * testing divide request, expecting right result
     */
    @Test
    public void testDivideRequest() {
        log.info(String.format("Testing request [%s]", divideRequest));
        final BigDecimal result = divideRequest.getFirst()
                .divide(divideRequest.getSecond())
                .setScale(4, RoundingMode.HALF_UP);
        assertEquals("Should divide", result, chain.processRequest(divideRequest));
    }


    /**
     * testing subtract request, expecting right result
     */
    @Test
    public void testSubtractRequest() {
        log.info(String.format("Testing request [%s]", subtractRequest));
        final BigDecimal result = subtractRequest.getFirst()
                .subtract(subtractRequest.getSecond())
                .setScale(4, RoundingMode.HALF_UP);
        assertEquals("Should subtract", result, chain.processRequest(subtractRequest));
    }


    /**
     * testing multiply request, expecting right result
     */
    @Test
    public void testMultiplyRequest() {
        log.info(String.format("Testing request [%s]", multiplyRequest));
        final BigDecimal result = multiplyRequest.getFirst()
                .multiply(multiplyRequest.getSecond())
                .setScale(4, RoundingMode.HALF_UP);
        assertEquals("Should multiply", result, chain.processRequest(multiplyRequest));
    }
}