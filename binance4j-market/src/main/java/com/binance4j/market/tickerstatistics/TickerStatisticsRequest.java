package com.binance4j.market.tickerstatistics;

import com.binance4j.core.request.Request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A request to get the 24 hour rolling window price change statistics.
 * Careful when accessing this with no symbol.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TickerStatisticsRequest extends Request {
    /**
     * The trading pair we want the ticker stats
     */
    private String symbol;

    /**
     * Constructor to get all ticker stats
     */
    public TickerStatisticsRequest() {
        super(40);
    }

    /**
     * Constructor to get the ticker stats of a symbol
     * 
     * @param symbol The trading pair we want the ticker stats
     */
    public TickerStatisticsRequest(String symbol) {
        super(1);
        this.symbol = symbol;
    }
}
