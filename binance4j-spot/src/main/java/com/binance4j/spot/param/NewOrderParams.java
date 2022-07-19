package com.binance4j.spot.param;

import java.math.BigDecimal;

import com.binance4j.core.client.RestClientConfiguration;
import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.OrderType;
import com.binance4j.core.dto.TimeInForce;
import com.binance4j.core.param.BaseOrderParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** An order to open or close a position */
@Data
@EqualsAndHashCode(callSuper = true)
public class NewOrderParams extends BaseOrderParams {
	/** Stop Limit price. */
	BigDecimal stopLimitPrice;

	/**
	 * Produces an order without a price
	 *
	 * @param symbol      the asset pair on which to place the order.
	 * @param type        the order type.
	 * @param side        order direction.
	 * @param quantity    the quantity of the order.
	 * @param timeInForce the lifetime of the order.
	 */
	public NewOrderParams(String symbol, OrderType type, OrderSide side, BigDecimal quantity, TimeInForce timeInForce) {
		super(1, symbol, type, side, quantity, timeInForce);
	}

	/**
	 * Produces an order without price with time in force GTC by default
	 *
	 * @param symbol   the asset pair on which to place the order.
	 * @param type     the order type.
	 * @param side     the direction of the order.
	 * @param quantity the quantity of the order.
	 */
	public NewOrderParams(String symbol, OrderType type, OrderSide side, BigDecimal quantity) {
		super(1, symbol, type, side, quantity);
	}

	/**
	 * Produces an order with a price
	 *
	 * @param symbol      the asset pair on which to place the order.
	 * @param type        the order type.
	 * @param side        the direction of the order.
	 * @param quantity    the quantity of the order.
	 * @param price       the order price.
	 * @param timeInForce the lifetime of the order.
	 */
	public NewOrderParams(String symbol, OrderType type, OrderSide side, BigDecimal quantity, BigDecimal price, TimeInForce timeInForce) {
		super(1, symbol, type, side, quantity, price, timeInForce);
	}

	/**
	 * Produces an order with a default price and time in force GTC
	 *
	 * @param symbol   the asset pair on which to place the order.
	 * @param type     the order type.
	 * @param side     the direction of the order.
	 * @param quantity the quantity of the order.
	 * @param price    the order price.
	 */
	public NewOrderParams(String symbol, OrderType type, OrderSide side, BigDecimal quantity, BigDecimal price) {
		super(1, symbol, type, side, quantity, price);
	}

	// STATIQUE //

	/**
	 * Produces a MARKET buy order
	 *
	 * @param symbol      The asset pair.
	 * @param quantity    The quantity.
	 * @param timeInForce The lifetime of the order.
	 * @return The order to execute.
	 */
	public static NewOrderParams buyMarket(String symbol, BigDecimal quantity, TimeInForce timeInForce) {
		return new NewOrderParams(symbol, OrderType.MARKET, OrderSide.BUY, quantity, timeInForce);
	}

	/**
	 * Produces a MARKET buy order
	 *
	 * @param symbol   The asset pair.
	 * @param quantity The quantity.
	 * @return The order to execute.
	 */
	public static NewOrderParams buyMarket(String symbol, BigDecimal quantity) {
		return buyMarket(symbol, quantity, RestClientConfiguration.getDefaultTimeInforce());
	}

	/**
	 * Produces a MARKET order
	 *
	 * @param symbol      The asset pair.
	 * @param quantity    The quantity.
	 * @param timeInForce The lifetime of the order.
	 * @return The order to execute.
	 */
	public static NewOrderParams sellMarket(String symbol, BigDecimal quantity, TimeInForce timeInForce) {
		return new NewOrderParams(symbol, OrderType.MARKET, OrderSide.SELL, quantity, timeInForce);
	}

	/**
	 * Produces a MARKET order
	 *
	 * @param symbol   The asset pair.
	 * @param quantity The quantity.
	 * @return The order to execute.
	 */
	public static NewOrderParams sellMarket(String symbol, BigDecimal quantity) {
		return sellMarket(symbol, quantity, RestClientConfiguration.getDefaultTimeInforce());
	}

	/**
	 * Produces a LIMIT buy order
	 *
	 * @param symbol      The asset pair.
	 * @param quantity    The quantity.
	 * @param price       The purchase price.
	 * @param timeInForce The lifetime of the order.
	 * @return The order to execute.
	 */
	public static NewOrderParams buyLimit(String symbol, BigDecimal quantity, BigDecimal price, TimeInForce timeInForce) {
		return new NewOrderParams(symbol, OrderType.LIMIT, OrderSide.BUY, quantity, price, timeInForce);
	}

	/**
	 * Produces a LIMIT buy order
	 *
	 * @param symbol   The asset pair.
	 * @param quantity The quantity.
	 * @param price    The purchase price.
	 * @return The order to execute.
	 */
	public static NewOrderParams buyLimit(String symbol, BigDecimal quantity, BigDecimal price) {
		return buyLimit(symbol, quantity, price, RestClientConfiguration.getDefaultTimeInforce());
	}

	/**
	 * Produces a sell LIMIT order
	 *
	 * @param symbol      The asset pair.
	 * @param quantity    The quantity.
	 * @param price       The selling price.
	 * @param timeInForce The lifetime of the order.
	 * @return The order to execute.
	 */
	public static NewOrderParams sellLimit(String symbol, BigDecimal quantity, BigDecimal price, TimeInForce timeInForce) {
		return new NewOrderParams(symbol, OrderType.LIMIT, OrderSide.SELL, quantity, price, timeInForce);
	}

	/**
	 * Produces a sell LIMIT order
	 *
	 * @param symbol   The asset pair.
	 * @param quantity The quantity.
	 * @param price    The purchase prices.
	 * @return The order to execute.
	 */
	public static NewOrderParams sellLimit(String symbol, BigDecimal quantity, BigDecimal price) {
		return sellLimit(symbol, quantity, price, RestClientConfiguration.getDefaultTimeInforce());
	}

	// QUOTE ORDERS

	/**
	 * Produces a MARKET buy order with quote quantity
	 *
	 * @param symbol      The asset pair.
	 * @param quantity    The quantity.
	 * @param timeInForce The lifetime of the order.
	 * @return The order to execute.
	 */
	public static NewOrderParams buyQuote(String symbol, BigDecimal quantity, TimeInForce timeInForce) {
		NewOrderParams order = new NewOrderParams(symbol, OrderType.MARKET, OrderSide.BUY, null, timeInForce);
		order.setQuoteOrderQuantity(quantity);
		return order;
	}

	/**
	 * Produces a MARKET buy order with quote quantity and default timeInForce
	 *
	 * @param symbol   The asset pair.
	 * @param quantity The quantity.
	 * @return The order to execute.
	 */
	public static NewOrderParams buyQuote(String symbol, BigDecimal quantity) {
		return buyQuote(symbol, quantity, RestClientConfiguration.getDefaultTimeInforce());
	}

	/**
	 * Produces a MARKET order with quote quantity
	 *
	 * @param symbol      The asset pair.
	 * @param quantity    The quantity.
	 * @param timeInForce The lifetime of the order.
	 * @return The order to execute.
	 */
	public static NewOrderParams sellQuote(String symbol, BigDecimal quantity, TimeInForce timeInForce) {
		NewOrderParams order = new NewOrderParams(symbol, OrderType.MARKET, OrderSide.SELL, null, timeInForce);
		order.setQuoteOrderQuantity(quantity);
		return order;
	}

	/**
	 * Produces a MARKET order with quote quantity and default timeInForce
	 *
	 * @param symbol   The asset pair.
	 * @param quantity The quantity.
	 * @return The order to execute.
	 */
	public static NewOrderParams sellQuote(String symbol, BigDecimal quantity) {
		return sellQuote(symbol, quantity, RestClientConfiguration.getDefaultTimeInforce());
	}

}
