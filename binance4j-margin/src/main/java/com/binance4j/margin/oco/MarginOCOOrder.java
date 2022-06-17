package com.binance4j.margin.oco;

import java.math.BigDecimal;

import com.binance4j.core.order.OCOOrder;
import com.binance4j.core.order.OrderSide;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MarginOCOOrder extends OCOOrder {
    private Boolean isIsolated;

    /**
     * @param symbol
     * @param side
     * @param quantity
     * @param price
     * @param stopPrice
     */
    public MarginOCOOrder(String symbol, OrderSide side, BigDecimal quantity, BigDecimal price, BigDecimal stopPrice) {
        super(symbol, side, quantity, price, stopPrice);
    }
}
