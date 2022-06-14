package com.binance4j.market.priceticker;

import com.binance4j.core.request.Request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** A request to get the latest price for a symbol or symbols. */
@Data
@EqualsAndHashCode(callSuper = true)
public class PriceTickerRequest extends Request {
    /**
     * Ticker symbol.
     */
    private String symbol;

    /**
     * Constructor for all symbols ticker
     */
    public PriceTickerRequest() {
        super(2);
    }

    /**
     * Constructor for a unique symbol
     * 
     * @param symbol The symbol we want the ticker
     */
    public PriceTickerRequest(String symbol) {
        super(1);
        this.symbol = symbol;
    }
}
