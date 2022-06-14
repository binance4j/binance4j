package com.binance4j.spot.order;

import java.math.BigDecimal;

import com.binance4j.core.misc.TimeInForce;
import com.binance4j.core.order.BaseOrder;
import com.binance4j.core.order.OrderSide;
import com.binance4j.core.order.OrderType;
import com.binance4j.core.request.RestClient;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** An order to open or close a position */
@Data
@EqualsAndHashCode(callSuper = true)
public class NewOrder extends BaseOrder {
	/**
	 * Stop Limit price
	 */
	BigDecimal stopLimitPrice;

	/**
	 * Produces an order without a price
	 *
	 * @param symbol      the asset pair on which to place the order
	 * @param type        the order type
	 * @param side        order direction
	 * @param quantity    the quantity of the order
	 * @param timeInForce the lifetime of the order
	 */
	public NewOrder(String symbol, OrderType type, OrderSide side, BigDecimal quantity, TimeInForce timeInForce) {
		super(1, symbol, type, side, quantity, timeInForce);
	}

	/**
	 * Produces an order without price with time in force GTC by default
	 *
	 * @param symbol   the asset pair on which to place the order
	 * @param type     the order type
	 * @param side     the direction of the order
	 * @param quantity the quantity of the order
	 */
	public NewOrder(String symbol, OrderType type, OrderSide side, BigDecimal quantity) {
		super(1, symbol, type, side, quantity);
	}

	/**
	 * Produces an order with a price
	 *
	 * @param symbol      the asset pair on which to place the order
	 * @param type        the order type
	 * @param side        the direction of the order
	 * @param quantity    the quantity of the order
	 * @param price       the order price
	 * @param timeInForce the lifetime of the order
	 */
	public NewOrder(String symbol, OrderType type, OrderSide side, BigDecimal quantity,
			BigDecimal price, TimeInForce timeInForce) {
		super(1, symbol, type, side, quantity, price, timeInForce);
	}

	/**
	 * Produces an order with a default price and time in force GTC
	 *
	 * @param symbol   the asset pair on which to place the order
	 * @param type     the order type
	 * @param side     the direction of the order
	 * @param quantity the quantity of the order
	 * @param price    the order price
	 */
	public NewOrder(String symbol, OrderType type, OrderSide side, BigDecimal quantity,
			BigDecimal price) {
		super(1, symbol, type, side, quantity, price);
	}

	// STATIQUE //

	/**
	 * Produces a MARKET buy order
	 *
	 * @param symbol      The asset pair
	 * @param quantity    The quantity
	 * @param timeInForce The lifetime of the order
	 * @return The order to execute
	 */
	public static NewOrder buyMarket(String symbol, BigDecimal quantity, TimeInForce timeInForce) {
		return new NewOrder(symbol, OrderType.MARKET, OrderSide.BUY, quantity, timeInForce);
	}

	/**
	 * Produces a MARKET buy order with default timeInForce
	 * 
	 * @param symbol   The asset pair
	 * @param quantity The quantity
	 * @see #buyMarket(String, BigDecimal, TimeInForce)
	 * @return The order to execute
	 */
	public static NewOrder buyMarket(String symbol, BigDecimal quantity) {
		return buyMarket(symbol, quantity, RestClient.getTimeInForce());
	}

	/**
	 * Produces a MARKET order
	 *
	 * @param symbol      The asset pair
	 * @param quantity    The quantity
	 * @param timeInForce The lifetime of the order
	 * @return The order to execute
	 */
	public static NewOrder sellMarket(String symbol, BigDecimal quantity, TimeInForce timeInForce) {
		return new NewOrder(symbol, OrderType.MARKET, OrderSide.SELL, quantity, timeInForce);
	}

	/**
	 * Produces a MARKET order with default timeInForce
	 *
	 * @see #buyMarket(String, BigDecimal, TimeInForce)
	 * @param symbol   The asset pair
	 * @param quantity The quantity
	 * @return The order to execute
	 */
	public static NewOrder sellMarket(String symbol, BigDecimal quantity) {
		return sellMarket(symbol, quantity, RestClient.getTimeInForce());
	}

	/**
	 * Produces a LIMIT buy order
	 *
	 * @param symbol      The asset pair
	 * @param quantity    The quantity
	 * @param price       The purchase price
	 * @param timeInForce The lifetime of the order
	 * @return The order to execute
	 */
	public static NewOrder buyLimit(String symbol, BigDecimal quantity, BigDecimal price,
			TimeInForce timeInForce) {
		return new NewOrder(symbol, OrderType.LIMIT, OrderSide.BUY, quantity, price, timeInForce);
	}

	/**
	 * Produces a LIMIT buy order with default timeInForce
	 *
	 * @see #buyLimit(String, BigDecimal, BigDecimal, TimeInForce)
	 * @param symbol   The asset pair
	 * @param quantity The quantity
	 * @param price    The purchase price
	 * @return The order to execute
	 */
	public static NewOrder buyLimit(String symbol, BigDecimal quantity, BigDecimal price) {
		return buyLimit(symbol, quantity, price, RestClient.getTimeInForce());
	}

	/**
	 * Produces a sell LIMIT order
	 *
	 * @param symbol      The asset pair
	 * @param quantity    The quantity
	 * @param price       The selling price
	 * @param timeInForce The lifetime of the order
	 * @return The order to execute
	 */
	public static NewOrder sellLimit(String symbol, BigDecimal quantity, BigDecimal price,
			TimeInForce timeInForce) {
		return new NewOrder(symbol, OrderType.LIMIT, OrderSide.SELL, quantity, price, timeInForce);
	}

	/**
	 * Produces a sell LIMIT order with default timeInForce
	 *
	 * @see #sellLimit(String, BigDecimal, BigDecimal, TimeInForce)
	 * @param symbol   The asset pair
	 * @param quantity The quantity
	 * @param price    The purchase prices
	 * @return The order to execute
	 */
	public static NewOrder sellLimit(String symbol, BigDecimal quantity, BigDecimal price) {
		return sellLimit(symbol, quantity, price, RestClient.getTimeInForce());
	}

	// QUOTE ORDERS

	/**
	 * Produces a MARKET buy order with quote quantity
	 *
	 * @param symbol      The asset pair
	 * @param quantity    The quantity
	 * @param timeInForce The lifetime of the order
	 * @return The order to execute
	 */
	public static NewOrder buyQuote(String symbol, BigDecimal quantity, TimeInForce timeInForce) {
		NewOrder order = new NewOrder(symbol, OrderType.MARKET, OrderSide.BUY, null, timeInForce);
		order.setQuoteOrderQty(quantity);
		return order;
	}

	/**
	 * Produces a MARKET buy order with quote quantity and default timeInForce
	 * 
	 * @param symbol   The asset pair
	 * @param quantity The quantity
	 * @see #buyQuote(String, BigDecimal, TimeInForce)
	 * @return The order to execute
	 */
	public static NewOrder buyQuote(String symbol, BigDecimal quantity) {
		return buyQuote(symbol, quantity, RestClient.getTimeInForce());
	}

	/**
	 * Produces a MARKET order with quote quantity
	 *
	 * @param symbol      The asset pair
	 * @param quantity    The quantity
	 * @param timeInForce The lifetime of the order
	 * @return The order to execute
	 */
	public static NewOrder sellQuote(String symbol, BigDecimal quantity, TimeInForce timeInForce) {
		NewOrder order = new NewOrder(symbol, OrderType.MARKET, OrderSide.SELL, null, timeInForce);
		order.setQuoteOrderQty(quantity);
		return order;
	}

	/**
	 * Produces a MARKET order with quote quantity and default timeInForce
	 *
	 * @see #buyMarket(String, BigDecimal, TimeInForce)
	 * @param symbol   The asset pair
	 * @param quantity The quantity
	 * @return The order to execute
	 */
	public static NewOrder sellQuote(String symbol, BigDecimal quantity) {
		return sellQuote(symbol, quantity, RestClient.getTimeInForce());
	}

}
