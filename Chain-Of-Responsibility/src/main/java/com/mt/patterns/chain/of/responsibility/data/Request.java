package com.mt.patterns.chain.of.responsibility.data;
/**
 * Created by max on 06/12/16.
 */

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

import java.math.BigDecimal;

public final class Request {

    private static final BigDecimal ZERO = BigDecimal.ZERO;

    private final BigDecimal first;
    private final BigDecimal second;
    private final Operation operation;

    public static Request newAddRequest(BigDecimal first, BigDecimal second) {
        return new Request(first, second, Operation.Add);
    }

    public static Request newSubtractRequest(BigDecimal first, BigDecimal second) {
        return new Request(first, second, Operation.subtract);
    }

    public static Request newDivideRequest(BigDecimal first, BigDecimal second) {
        return new Request(first, second, Operation.Divide);
    }

    public static Request newMultiplyRequest(BigDecimal first, BigDecimal second) {
        return new Request(first, second, Operation.Multiply);
    }

    public static Request newUnknownRequest() {
        return new Request(ZERO, ZERO, Operation.Unknown);
    }

    private Request(BigDecimal first, BigDecimal second, Operation operation) {
        Preconditions.checkNotNull(first, "no nulls allowed");
        Preconditions.checkNotNull(second, "no nulls allowed");
        Preconditions.checkNotNull(operation, "no nulls allowed");

        if (Operation.Divide.equals(operation) && ZERO.compareTo(second) == 0) {
            throw new IllegalArgumentException("Cannot handle the request");
        }

        this.first = first;
        this.second = second;
        this.operation = operation;
    }

    public BigDecimal getFirst() {
        return first;
    }

    public BigDecimal getSecond() {
        return second;
    }

    public Operation getOperation() {
        return operation;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("first", first)
                .add("second", second)
                .add("operation", operation)
                .toString();
    }
}