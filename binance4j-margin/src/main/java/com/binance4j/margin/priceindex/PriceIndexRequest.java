package com.binance4j.margin.priceindex;

import com.binance4j.core.request.Request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PriceIndexRequest extends Request {
    private String symbol;

    public PriceIndexRequest(String symbol) {
        super(10);
        this.symbol = symbol;
    }
}
