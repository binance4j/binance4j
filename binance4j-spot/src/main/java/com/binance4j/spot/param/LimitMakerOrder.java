package com.binance4j.spot.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.OrderType;
import com.binance4j.core.dto.RateLimitType;

/** A LIMIT_MAKER order. */
@Param(weight = 1, isOrder = true, type = RateLimitType.UID_AND_IP)
public class LimitMakerOrder extends BaseOrder {
	/** Order quantity */
	final String quantity;
	/** Order price */
	final String price;

	/**
	 * 
	 * @param symbol      Symbol.
	 * @param side        Side.
	 * @param quantity    Order quantity.
	 * @param price       Order price.
	 * @param timeInForce Order time in force.
	 */
	private LimitMakerOrder(String symbol, OrderSide side, String quantity, String price) {
		super(symbol, side, OrderType.LIMIT_MAKER);
		this.quantity = quantity;
		this.price = price;
	}

	/**
	 * Creates an instance of {@link LimitMakerOrder} in the BUY side.
	 * 
	 * @param symbol      Symbol.
	 * @param quantity    Order quantity.
	 * @param price       Order price.
	 * @param timeInForce Order time in force.
	 * @return An instance of {@link LimitMakerOrder}.
	 */
	public static LimitMakerOrder buy(String symbol, String quantity, String price) {
		return new LimitMakerOrder(symbol, OrderSide.BUY, quantity, price);
	}

	/**
	 * Creates an instance of {@link LimitMakerOrder} in the SELL side.
	 * 
	 * @param symbol      Symbol.
	 * @param quantity    Order quantity.
	 * @param price       Order price.
	 * @param timeInForce Order time in force.
	 * @return An instance of {@link LimitMakerOrder}.
	 */
	public static LimitMakerOrder sell(String symbol, String quantity, String price) {
		return new LimitMakerOrder(symbol, OrderSide.SELL, quantity, price);
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

	@Override
	public String toString() {
		return "LimitMakerOrder [side=" + side + ", symbol=" + symbol + ", type=" + type + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
}