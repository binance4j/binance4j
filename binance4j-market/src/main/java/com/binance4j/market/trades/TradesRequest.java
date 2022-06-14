package com.binance4j.market.trades;

import com.binance4j.core.request.Request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** A request to get recent trades */
@Data
@EqualsAndHashCode(callSuper = true)
public class TradesRequest extends Request {
    /**
     * The symbol we want the trades
     */
    private String symbol;
    /**
     * The trades size. Default 500; max 1000.
     */
    private Integer limit = 500;

    /**
     * Default constructor
     * 
     * @param symbol The symbol we want the trades
     */
    public TradesRequest(String symbol) {
        super(1);
        this.symbol = symbol;
    }

    /**
     * Constructor
     * 
     * @param symbol The symbol we want the trades
     * @param limit  The trades size. Default 500; max 1000.
     */
    public TradesRequest(String symbol, int limit) {
        this(symbol);
        this.limit = limit;
    }
}
