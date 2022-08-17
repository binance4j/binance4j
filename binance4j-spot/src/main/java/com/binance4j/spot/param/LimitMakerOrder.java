package com.binance4j.spot.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.OrderType;
import com.binance4j.core.dto.RateLimitType;

/** A LIMIT_MAKER order. */
@Param(weight = 1, isOrder = true, type = RateLimitType.UID_AND_IP)
public class LimitMakerOrder extends BaseOrder {
	/** Order quantity */
	String quantity;
	/** Order price */
	String price;

	/**
	 * 
	 * @param symbol   Symbol.
	 * @param side     Side.
	 * @param quantity Order quantity.
	 * @param price    Order price.
	 */
	public LimitMakerOrder(String symbol, OrderSide side, String quantity, String price) {
		super(symbol, side, OrderType.LIMIT_MAKER);
		this.quantity = quantity;
		this.price = price;
	}

	/**
	 * Creates an instance of {@link LimitMakerOrder} in the BUY side.
	 * 
	 * @param symbol   Symbol.
	 * @param quantity Order quantity.
	 * @param price    Order price.
	 * @return An instance of {@link LimitMakerOrder}.
	 */
	public static LimitMakerOrder buy(String symbol, String quantity, String price) {
		return new LimitMakerOrder(symbol, OrderSide.BUY, quantity, price);
	}

	/**
	 * Creates an instance of {@link LimitMakerOrder} in the SELL side.
	 * 
	 * @param symbol   Symbol.
	 * @param quantity Order quantity.
	 * @param price    Order price.
	 * @return An instance of {@link LimitMakerOrder}.
	 */
	public static LimitMakerOrder sell(String symbol, String quantity, String price) {
		return new LimitMakerOrder(symbol, OrderSide.SELL, quantity, price);
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

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "LimitMakerOrder [side=" + side + ", symbol=" + symbol + ", type=" + type + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
}