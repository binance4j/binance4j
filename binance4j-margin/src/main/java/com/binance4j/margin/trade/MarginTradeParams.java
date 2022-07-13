package com.binance4j.margin.trade;

import com.binance4j.core.param.IntervalParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MarginTradeParams extends IntervalParams {
    private String symbol;
    private Boolean isIsolated;
    private Long fromId;
    private Integer limit;

    public MarginTradeParams() {
        super(10);
    }
}
