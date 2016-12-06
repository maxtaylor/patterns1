package com.mt.patterns.chain.of.responsibility.handler;

import com.mt.patterns.chain.of.responsibility.data.Operation;
import com.mt.patterns.chain.of.responsibility.data.Request;

import java.math.BigDecimal;

/**
 * Created by max on 06/12/16.
 */
public final class ChainMultiplyHandlerImpl implements Chain {
    private final Chain nextHandler;

    public ChainMultiplyHandlerImpl(Chain next) {
        this.nextHandler = next;
    }

    public BigDecimal processRequest(Request request) {
        return Operation.Multiply.equals(request.getOperation()) ?
                request.getFirst().multiply(request.getSecond())
                : nextHandler.processRequest(request);
    }
}