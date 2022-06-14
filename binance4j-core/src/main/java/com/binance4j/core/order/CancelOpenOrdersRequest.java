package com.binance4j.core.order;

import com.binance4j.core.request.FramedRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** Request to cancel an order */
@Data
@EqualsAndHashCode(callSuper = true)
public class CancelOpenOrdersRequest extends FramedRequest {
    /**
     * The trade symbol
     */
    private String symbol;
    /**
     * for isolated margin or not, "TRUE", "FALSE"，default "FALSE"
     */
    private Boolean isIsolated;

    /**
     * Constructor
     * 
     * @param symbol The trade symbol
     */
    public CancelOpenOrdersRequest(String symbol) {
        super(1);
        this.symbol = symbol;
    }
}
