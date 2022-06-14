package com.binance4j.core.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The base of a request with a recvWindow and a timestamp
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class FramedRequest extends Request {
    /**
     * The request timestamp
     */
    protected long timestamp = System.currentTimeMillis();

    protected FramedRequest() {
        super();
    }

    /**
     * Constructor
     *
     * @param weight The Request weight
     */
    protected FramedRequest(int weight) {
        super(weight, false);
    }

    /**
     * Constructor
     * 
     * @param weight         The Request weight
     * @param isOrderRequest Is the request a trading order
     */
    protected FramedRequest(int weight, Boolean isOrderRequest) {
        super(weight, isOrderRequest);
    }
}