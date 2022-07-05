package com.binance4j.margin.pair;

import com.binance4j.core.request.Request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MarginPairRequest extends Request {
    private String symbol;

    public MarginPairRequest(String symbol) {
        super(10);
        this.symbol = symbol;
    }
}