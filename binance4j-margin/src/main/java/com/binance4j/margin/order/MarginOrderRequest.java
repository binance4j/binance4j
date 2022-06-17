package com.binance4j.margin.order;

import com.binance4j.core.request.FramedRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MarginOrderRequest extends FramedRequest {
    private String symbol;
    /** for isolated margin or not, "TRUE", "FALSE"，default "FALSE" */
    private Boolean isIsolated;
    private long orderId;
    private String origClientOrderId;

    public MarginOrderRequest(String symbol) {
        super(10);
        this.symbol = symbol;
    }
}
