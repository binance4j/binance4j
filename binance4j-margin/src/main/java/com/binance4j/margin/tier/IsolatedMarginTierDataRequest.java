package com.binance4j.margin.tier;

import com.binance4j.core.request.FramedRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class IsolatedMarginTierDataRequest extends FramedRequest {
    private String symbol;
    private String tier;

    public IsolatedMarginTierDataRequest(String symbol) {
        super(1);
        this.symbol = symbol;
    }
}
