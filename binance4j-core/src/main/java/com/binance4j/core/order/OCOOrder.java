package com.binance4j.core.order;

import java.math.BigDecimal;

import com.binance4j.core.misc.TimeInForce;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** An order made of two when one cancels the other */
@Data
@EqualsAndHashCode(callSuper = true)
public class OCOOrder extends Order {
    /**
     * A unique Id for the entire orderList
     */
    private String listClientOrderId;
    /**
     * A unique Id for the limit order
     */
    private String limitClientOrderId;
    /**
     * Used to make the LIMIT_MAKER leg an iceberg order.
     */
    private BigDecimal limitIcebergQty;
    /**
     * A unique Id for the stop loss/stop loss limit leg
     */
    private String stopClientOrderId;
    /**
     * If provided, stopLimitTimeInForce is required.
     */
    private BigDecimal stopLimitPrice;
    /**
     * Used with STOP_LOSS_LIMIT leg to make an iceberg order.
     */
    private BigDecimal stopIcebergQty;
    /**
     * Valid values are GTC/FOK/IOC
     */
    private TimeInForce stopLimitTimeInForce;

    /**
     * Constructor - Produces an OCO order
     *
     * @param symbol    The symbol the order is made on
     * @param side      The order side (BUY/SELL)
     * @param quantity  The order quantity
     * @param price     The order price
     * @param stopPrice The stop price
     */
    public OCOOrder(String symbol, OrderSide side, BigDecimal quantity, BigDecimal price, BigDecimal stopPrice) {
        super(1, symbol, side, quantity);
        this.price = price;
        this.stopPrice = stopPrice;
    }
}
