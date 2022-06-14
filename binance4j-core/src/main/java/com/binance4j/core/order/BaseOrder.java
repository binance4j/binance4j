package com.binance4j.core.order;

import com.binance4j.core.misc.TimeInForce;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

/** The base of a SPOT and MARGIN order */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BaseOrder extends Order {
    /**
     * The order type
     */
    protected OrderType type;
    /**
     * Le order lifetime
     */
    protected TimeInForce timeInForce;
    /**
     * The quote order quantity
     */
    protected BigDecimal quoteOrderQty;
    /**
     * The iceberg quantity
     */
    protected BigDecimal icebergQty;
    /**
     * The order unique id. Else is produced automatically.
     */
    protected String newClientOrderId;

    protected BaseOrder() {
    }

    /**
     * Produces an order without price
     *
     * @param weight      The order weight
     * @param symbol      The symbol the order is made on
     * @param type        The order type
     * @param side        The order side (BUY/SELL)
     * @param quantity    The order quantity
     * @param timeInForce The order lifetime
     */
    public BaseOrder(int weight,
            String symbol, OrderType type, OrderSide side, BigDecimal quantity, TimeInForce timeInForce) {
        super(weight, symbol, side, quantity);
        this.type = type;
        // timeInForce useless for market order
        this.timeInForce = type == OrderType.MARKET ? null : timeInForce;
    }

    /**
     * Produces an order without price and GTC time in force
     *
     * @param weight   The order weight
     * @param symbol   The symbol the order is made on
     * @param type     The order type
     * @param side     The order side (BUY/SELL)
     * @param quantity The order quantity
     */
    public BaseOrder(int weight, String symbol, OrderType type, OrderSide side, BigDecimal quantity) {
        super(weight, symbol, side, quantity);
        this.type = type;
        this.timeInForce = TimeInForce.GTC;
    }

    /**
     * Produces an order with a price
     *
     * @param weight      The order weight
     * @param symbol      The symbol the order is made on
     * @param type        The order type
     * @param side        The order side (BUY/SELL)
     * @param quantity    The order quantity
     * @param price       The order price
     * @param timeInForce The order lifetime
     */
    public BaseOrder(int weight,
            String symbol, OrderType type, OrderSide side, BigDecimal quantity, BigDecimal price,
            TimeInForce timeInForce) {
        this(weight, symbol, type, side, quantity, timeInForce);
        this.price = price;
    }

    /**
     * Produces an order with a price and GTC time in force
     *
     * @param weight   The order weight
     * @param symbol   The symbol the order is made on
     * @param type     The order type
     * @param side     The order side (BUY/SELL)
     * @param quantity The order quantity
     * @param price    The order price
     */
    public BaseOrder(int weight, String symbol, OrderType type, OrderSide side, BigDecimal quantity, BigDecimal price) {
        this(weight, symbol, type, side, quantity);
        this.price = price;
    }

    /**
     * Sets quantity and remove quote order quantity because you can't have both in
     * an order
     * 
     * @param quantity The new quantity
     */
    @Override
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
        this.quoteOrderQty = null;
    }

    /**
     * Sets quote order quantity and remove quantity because you can't have both in
     * an order
     * 
     * @param quoteOrderQuantity The new quantity
     * 
     */
    public void setQuoteOrderQty(BigDecimal quoteOrderQuantity) {
        this.quantity = null;
        this.quoteOrderQty = quoteOrderQuantity;
    }
}