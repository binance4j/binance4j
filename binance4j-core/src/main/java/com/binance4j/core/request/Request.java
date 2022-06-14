package com.binance4j.core.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * The base of every Binance Request
 */
@Data
public class Request {
    /**
     * The default receiving window
     */
    @Getter
    @Setter
    private static long recvWindow = 60_000L;

    /**
     * The request weight
     */
    private final int weight;
    /**
     * Is this request generating an order?
     */
    private final Boolean isOrderRequest;

    /**
     * Constructor
     * 
     * @param weight The Request weight
     */
    public Request(int weight) {
        this(weight, false);
    }

    /**
     * Constructor
     * 
     * @param weight         The Request weight
     * @param isOrderRequest Is the request a trading order
     */
    public Request(int weight, Boolean isOrderRequest) {
        this.weight = weight;
        this.isOrderRequest = isOrderRequest;
    }
}