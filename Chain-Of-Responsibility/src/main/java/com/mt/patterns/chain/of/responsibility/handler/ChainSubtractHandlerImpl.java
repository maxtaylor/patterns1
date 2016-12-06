package com.mt.patterns.chain.of.responsibility.handler;

import com.mt.patterns.chain.of.responsibility.data.Operation;
import com.mt.patterns.chain.of.responsibility.data.Request;

import java.math.BigDecimal;

/**
 * Created by max on 06/12/16.
 */
public final class ChainSubtractHandlerImpl implements Chain {

    private final Chain nextHandler;

    public ChainSubtractHandlerImpl(Chain next) {
        this.nextHandler = next;
    }

    public BigDecimal processRequest(Request request) {
        return Operation.subtract.equals(request.getOperation()) ?
                request.getFirst().subtract(request.getSecond())
                : nextHandler.processRequest(request);
    }
}