package com.binance4j.margin.order;

import com.binance4j.core.request.IntervalRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MarginAllOrdersRequest extends IntervalRequest {
    private String symbol;
    private Boolean isIsolated;
    private long orderId;
    private long limit;

    public MarginAllOrdersRequest() {
        super(200);
    }
}
