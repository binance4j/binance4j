package com.binance4j.margin.order;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MarginOrderParams extends FramedParams {
    private String symbol;
    /** for isolated margin or not, "TRUE", "FALSE"，default "FALSE" */
    private Boolean isIsolated;
    private long orderId;
    private String origClientOrderId;

    public MarginOrderParams(String symbol) {
        super(10);
        this.symbol = symbol;
    }
}
