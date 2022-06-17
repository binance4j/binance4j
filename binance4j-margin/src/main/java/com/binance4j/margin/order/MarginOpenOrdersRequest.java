package com.binance4j.margin.order;

import com.binance4j.core.request.FramedRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MarginOpenOrdersRequest extends FramedRequest {
    private String symbol;
    private Boolean isIsolated;

    public MarginOpenOrdersRequest() {
        super(10);
    }
}
