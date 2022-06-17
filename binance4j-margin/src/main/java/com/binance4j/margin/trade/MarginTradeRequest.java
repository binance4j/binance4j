package com.binance4j.margin.trade;

import com.binance4j.core.request.IntervalRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MarginTradeRequest extends IntervalRequest {
    private String symbol;
    private Boolean isIsolated;
    private Long fromId;
    private Integer limit;

    public MarginTradeRequest() {
        super(10);
    }
}
