package com.binance4j.core.order;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** Request to cancel an order. */
@Data
@EqualsAndHashCode(callSuper = true)
public class CancelOpenOrdersParams extends FramedParams {
    /** The trade symbol */
    private String symbol;
    /** for isolated margin or not, "TRUE", "FALSE"，default "FALSE" */
    private Boolean isIsolated;

    /**
     * 
     * 
     * @param symbol The trade symbol
     */
    public CancelOpenOrdersParams(String symbol) {
        super(1);
        this.symbol = symbol;
    }
}
