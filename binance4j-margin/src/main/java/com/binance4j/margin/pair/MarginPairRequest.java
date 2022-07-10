package com.binance4j.margin.pair;

import com.binance4j.core.request.FramedRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MarginPairRequest extends FramedRequest {
    private String symbol;

    public MarginPairRequest(String symbol) {
        super(10);
        this.symbol = symbol;
    }
}