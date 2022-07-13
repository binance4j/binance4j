package com.binance4j.margin.order;

import com.binance4j.core.param.IntervalParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MarginAllOrdersParams extends IntervalParams {
    private String symbol;
    private Boolean isIsolated;
    private Long orderId;
    private Long limit;

    public MarginAllOrdersParams(String symbol) {
        super(200);
        this.symbol = symbol;
    }
}
