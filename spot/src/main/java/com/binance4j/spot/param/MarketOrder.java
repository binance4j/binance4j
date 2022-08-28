package com.binance4j.spot.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.OrderType;
import com.binance4j.core.dto.RateLimitType;

/** A MARKET order. */
@Param(weight = 1, isOrder = true, type = RateLimitType.UID_AND_IP)
public class MarketOrder extends BaseOrder {
	/** Order quantity */
	String quantity;

	/**
	 * @param symbol Symbol.
	 * @param side   Side.
	 */
	public MarketOrder(String symbol, OrderSide side, String quantity) {
		super(symbol, side, OrderType.MARKET);
		this.quantity = quantity;
	}

	/**
	 * Creates an instance of {@link MarketOrder} in the BUY side.
	 * 
	 * @param symbol   Symbol.
	 * @param quantity Quantity.
	 * @return An instance of {@link MarketOrder}.
	 */
	public static MarketOrder buy(String symbol, String quantity) {
		return new MarketOrder(symbol, OrderSide.BUY, quantity);
	}

	/**
	 * Creates an instance of {@link MarketOrder} in the SELL side.
	 * 
	 * @param symbol   Symbol.
	 * @param quantity Quantity.
	 * @return An instance of {@link MarketOrder}.
	 */
	public static MarketOrder sell(String symbol, String quantity) {
		return new MarketOrder(symbol, OrderSide.SELL, quantity);
	}

	/**
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "MarketOrder [side=" + side + ", symbol=" + symbol + ", type=" + type + ", quantity=" + quantity + "]";
	}
}