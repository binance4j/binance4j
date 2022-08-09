package com.binance4j.spot.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.OrderType;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.TimeInForce;

/** A LIMIT order. */
@Param(weight = 1, isOrder = true, type = RateLimitType.UID_AND_IP)
public class LimitOrder extends BaseOrder {
	/** Order quantity */
	final String quantity;
	/** Order price */
	final String price;
	/** Order time in force */
	final TimeInForce timeInForce;

	/**
	 * 
	 * @param symbol      Symbol.
	 * @param side        Side.
	 * @param quantity    Order quantity.
	 * @param price       Order price.
	 * @param timeInForce Order time in force.
	 */
	private LimitOrder(String symbol, OrderSide side, String quantity, String price, TimeInForce timeInForce) {
		super(symbol, side, OrderType.LIMIT);
		this.quantity = quantity;
		this.price = price;
		this.timeInForce = timeInForce;
	}

	/**
	 * Creates an instance of {@link LimitOrder} in a BUY side.
	 * 
	 * @param symbol      Symbol.
	 * @param quantity    Order quantity.
	 * @param price       Order price.
	 * @param timeInForce Order time in force.
	 * @return An instance of {@link LimitOrder}.
	 */
	public static LimitOrder buy(String symbol, String quantity, String price, TimeInForce timeInForce) {
		return new LimitOrder(symbol, OrderSide.BUY, quantity, price, timeInForce);
	}

	/**
	 * Creates an instance of {@link LimitOrder} in a SELL side.
	 * 
	 * @param symbol      Symbol.
	 * @param quantity    Order quantity.
	 * @param price       Order price.
	 * @param timeInForce Order time in force.
	 * @return An instance of {@link LimitOrder}.
	 */
	public static LimitOrder sell(String symbol, String quantity, String price, TimeInForce timeInForce) {
		return new LimitOrder(symbol, OrderSide.SELL, quantity, price, timeInForce);
	}

	/**
	 * Creates an instance of {@link LimitOrder} in the BUY side.
	 * 
	 * @param symbol      Symbol.
	 * @param quantity    Order quantity.
	 * @param price       Order price.
	 * @param timeInForce Order time in force.
	 * @return An instance of {@link LimitOrder}.
	 */
	public static LimitOrder buy(String symbol, String quantity, String price) {
		return new LimitOrder(symbol, OrderSide.BUY, quantity, price, TimeInForce.GTC);
	}

	/**
	 * Creates an instance of {@link LimitOrder} in the SELL side.
	 * 
	 * @param symbol      Symbol.
	 * @param quantity    Order quantity.
	 * @param price       Order price.
	 * @param timeInForce Order time in force.
	 * @return An instance of {@link LimitOrder}.
	 */
	public static LimitOrder sell(String symbol, String quantity, String price) {
		return new LimitOrder(symbol, OrderSide.SELL, quantity, price, TimeInForce.GTC);
	}

	/**
	 * @return the quantity
	 */
	public String quantity() {
		return quantity;
	}

	/**
	 * @return the price
	 */
	public String price() {
		return price;
	}

	/**
	 * @return the timeInForce
	 */
	public TimeInForce timeInForce() {
		return timeInForce;
	}

	@Override
	public String toString() {
		return "LimitOrder [side=" + side + ", symbol=" + symbol + ", type=" + type + ", price=" + price + ", quantity="
				+ quantity + ", timeInForce=" + timeInForce + "]";
	}
}