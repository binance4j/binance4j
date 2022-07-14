package com.binance4j.core.param;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** The base of a request with a recvWindow and a timestamp */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class FramedParams extends Params {
    /** The request timestamp */
    protected long timestamp = System.currentTimeMillis();

    protected FramedParams() {
        super();
    }

    /**
     *
     * 
     * @param weight The Request weight
     */
    protected FramedParams(int weight) {
        super(weight, false);
    }

    /**
     * 
     * 
     * @param weight         The Request weight
     * @param isOrderRequest Is the request a trading order
     */
    protected FramedParams(int weight, Boolean isOrderRequest) {
        super(weight, isOrderRequest);
    }
}