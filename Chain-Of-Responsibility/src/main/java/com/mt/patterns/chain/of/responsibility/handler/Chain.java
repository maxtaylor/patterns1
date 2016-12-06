package com.mt.patterns.chain.of.responsibility.handler;

import com.mt.patterns.chain.of.responsibility.data.Request;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by max on 06/12/16.
 * Attempting to work the object through a generic sequence of steps, while each step can handle a particular type of request.
 */

public interface Chain {
    BigDecimal processRequest(Request request);

    final class ChainImpl implements Chain {
        private final Chain chain;

        public ChainImpl() {
            final Chain defaultHandler = new ChainDefaultHandlerImpl();
            final Chain addHandler = new ChainAddHandlerImpl(defaultHandler);
            final Chain divideHandler = new ChainDivideHandlerImpl(addHandler);
            final Chain multiplyHandler = new ChainMultiplyHandlerImpl(divideHandler);
            this.chain = new ChainSubtractHandlerImpl(multiplyHandler);
        }

        public BigDecimal processRequest(Request request) {
            return chain.processRequest(request)
                    .setScale(4, RoundingMode.HALF_UP);
        }
    }
}