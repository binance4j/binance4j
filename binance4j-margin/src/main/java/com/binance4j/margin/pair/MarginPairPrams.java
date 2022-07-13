package com.binance4j.margin.pair;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MarginPairPrams extends FramedParams {
    private String symbol;

    public MarginPairPrams(String symbol) {
        super(10);
        this.symbol = symbol;
    }
}