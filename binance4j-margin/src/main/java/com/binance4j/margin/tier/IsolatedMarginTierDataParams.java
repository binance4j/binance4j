package com.binance4j.margin.tier;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class IsolatedMarginTierDataParams extends FramedParams {
    private String symbol;
    private String tier;

    public IsolatedMarginTierDataParams(String symbol) {
        super(1);
        this.symbol = symbol;
    }
}
