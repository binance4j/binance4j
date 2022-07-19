package com.binance4j.core.param;

import java.math.BigDecimal;

import com.binance4j.core.dto.NewOrderResponseType;
import com.binance4j.core.dto.OrderSide;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** A trading order. */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class OrderParams extends FramedParams {
	/** The order symbol */
	protected String symbol;
	/** The order side */
	protected OrderSide side;
	/** The order quantity */
	protected BigDecimal quantity;
	/** The order price */
	protected BigDecimal price;
	/** The stop price */
	protected BigDecimal stopPrice;
	/** The order response type Default: RESULT. */
	protected NewOrderResponseType newOrderRespType;

	/** Constructor */
	protected OrderParams() {
		super();
	}

	/**
	 * Produces an order without price
	 *
	 * @param weight   The order weight.
	 * @param symbol   The symbol the order is made on.
	 * @param side     The order side (BUY/SELL).
	 * @param quantity The order quantity.
	 */
	protected OrderParams(int weight, String symbol, OrderSide side, BigDecimal quantity) {
		super(weight, true);
		this.symbol = symbol;
		this.side = side;
		this.quantity = quantity;
	}

	/**
	 * Produces an order with a price
	 *
	 * @param weight   The order weight.
	 * @param symbol   The symbol the order is made on.
	 * @param side     The order side (BUY/SELL).
	 * @param quantity The order quantity.
	 * @param price    The order price.
	 */
	protected OrderParams(int weight, String symbol, OrderSide side, BigDecimal quantity, BigDecimal price) {
		this(weight, symbol, side, quantity);
		this.price = price;
	}
}
