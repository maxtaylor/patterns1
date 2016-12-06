package com.mt.patterns.chain.of.responsibility.handler;

import com.mt.patterns.chain.of.responsibility.data.Request;

import java.math.BigDecimal;

/**
 * Created by max on 06/12/16.
 */
public final class ChainDefaultHandlerImpl implements Chain {
    public BigDecimal processRequest(Request request) {
        throw new IllegalArgumentException("Cannot handle the request");
    }
}