package com.binance4j.margin.symbol;

import com.binance4j.core.request.Request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MarginSymbolRequest extends Request {
    private String symbol;

    public MarginSymbolRequest(String symbol) {
        super(10);
        this.symbol = symbol;
    }
}