package com.binance4j.market.averageprice;

import com.binance4j.core.request.Request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** A request to get the average price of a trading pair */
@Data
@EqualsAndHashCode(callSuper = true)
public class AveragePriceRequest extends Request {
    /**
     * The trading pair we want the price
     */
    private String symbol;

    /**
     * Default constructor
     * 
     * @param symbol The trading pair we want the price
     */
    public AveragePriceRequest(String symbol) {
        super(1);
        this.symbol = symbol;
    }
}
