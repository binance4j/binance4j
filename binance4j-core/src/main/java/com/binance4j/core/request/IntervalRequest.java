package com.binance4j.core.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A Request with a result interval
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class IntervalRequest extends FramedRequest {
    /**
     * The starting timestamp of the results
     */
    protected Long startTime;
    /**
     * The ending timestamp of the results
     */
    protected Long endTime;

    /**
     * Constructor
     * 
     * @param weight The Request weight
     */
    public IntervalRequest(int weight) {
        super(weight);
    }

    /**
     * Constructor
     * 
     * @param weight         The Request weight
     * @param isOrderRequest Is the request a trading order
     */
    public IntervalRequest(int weight, Boolean isOrderRequest) {
        super(weight, isOrderRequest);
    }
}
