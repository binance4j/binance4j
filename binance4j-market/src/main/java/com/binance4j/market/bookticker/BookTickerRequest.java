package com.binance4j.market.bookticker;

import com.binance4j.core.request.Request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A request to get the the best price/qty on the order book for a symbol or
 * symbols.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BookTickerRequest extends Request {
    /**
     * Ticker symbol.
     */
    private String symbol;

    /**
     * Constructor to get the ticker of all symbols
     */
    public BookTickerRequest() {
        super(2);
    }

    /**
     * Constructor to get the ticker of a symbol
     * 
     * @param symbol The trading pair we want the ticker
     */
    public BookTickerRequest(String symbol) {
        super(1);
        this.symbol = symbol;
    }
}
