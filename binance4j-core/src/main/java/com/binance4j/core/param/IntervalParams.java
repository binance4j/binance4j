package com.binance4j.core.param;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A Request with a result interval
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class IntervalParams extends FramedParams {
    /**
     * The starting timestamp of the results
     */
    protected Long startTime;
    /**
     * The ending timestamp of the results
     */
    protected Long endTime;

    public IntervalParams() {
        super();
    }

    /**
     * 
     * 
     * @param weight The Request weight
     */
    public IntervalParams(int weight) {
        super(weight);
    }

    /**
     * 
     * 
     * @param weight         The Request weight
     * @param isOrderRequest Is the request a trading order
     */
    public IntervalParams(int weight, Boolean isOrderRequest) {
        super(weight, isOrderRequest);
    }
}
