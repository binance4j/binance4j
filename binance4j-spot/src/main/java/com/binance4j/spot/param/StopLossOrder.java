package com.binance4j.spot.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.OrderType;
import com.binance4j.core.dto.RateLimitType;

/** A STOP_LOSS order. */
@Param(weight = 1, isOrder = true, type = RateLimitType.UID_AND_IP)
public class StopLossOrder extends BaseOrder {
	/** Order quantity. */
	final String quantity;
	/** Order stop price. */
	final String stopPrice;
	/** Trailing delta. */
	final Long trailingDelta;

	/**
	 * 
	 * @param symbol    Symbol.
	 * @param side      Side.
	 * @param quantity  Order quantity.
	 * @param stopPrice Order price.
	 */
	private StopLossOrder(String symbol, OrderSide side, String quantity, String stopPrice) {
		super(symbol, side, OrderType.STOP_LOSS);
		this.quantity = quantity;
		this.stopPrice = stopPrice;
		this.trailingDelta = null;
	}

	/**
	 * 
	 * @param symbol    Symbol.
	 * @param side      Side.
	 * @param quantity  Order quantity.
	 * @param stopPrice Order price.
	 */
	private StopLossOrder(String symbol, OrderSide side, String quantity, Long trailingDelta) {
		super(symbol, side, OrderType.STOP_LOSS);
		this.quantity = quantity;
		this.trailingDelta = trailingDelta;
		this.stopPrice = null;
	}

	/**
	 * Creates an instance of {@link StopLossOrder} in the BUY side.
	 * 
	 * @param symbol    Symbol.
	 * @param quantity  Quantity.
	 * @param stopPrice Stop price.
	 * @return An instance of {@link StopLossOrder}.
	 */
	public static StopLossOrder buy(String symbol, String quantity, String stopPrice) {
		return new StopLossOrder(symbol, OrderSide.BUY, quantity, stopPrice);
	}

	/**
	 * Creates an instance of {@link StopLossOrder} in the SELL side.
	 * 
	 * @param symbol    Symbol.
	 * @param quantity  Quantity.
	 * @param stopPrice Stop price.
	 * @return An instance of {@link StopLossOrder}.
	 */
	public static StopLossOrder sell(String symbol, String quantity, String stopPrice) {
		return new StopLossOrder(symbol, OrderSide.SELL, quantity, stopPrice);
	}

	/**
	 * Creates an instance of {@link StopLossOrder} in the BUY side.
	 * 
	 * @param symbol        Symbol.
	 * @param quantity      Quantity.
	 * @param trailingDelta Trailing delta.
	 * @return An instance of {@link StopLossOrder}.
	 */
	public static StopLossOrder buy(String symbol, String quantity, Long trailingDelta) {
		return new StopLossOrder(symbol, OrderSide.BUY, quantity, trailingDelta);
	}

	/**
	 * Creates an instance of {@link StopLossOrder} in the SELL side.
	 * 
	 * @param symbol        Symbol.
	 * @param quantity      Quantity.
	 * @param trailingDelta Trailing delta.
	 * @return An instance of {@link StopLossOrder}.
	 */
	public static StopLossOrder sell(String symbol, String quantity, Long trailingDelta) {
		return new StopLossOrder(symbol, OrderSide.SELL, quantity, trailingDelta);
	}

	/**
	 * @return the quantity
	 */
	public String quantity() {
		return quantity;
	}

	/**
	 * @return the stopPrice
	 */
	public String stopPrice() {
		return stopPrice;
	}

	/**
	 * @return the trailingDelta
	 */
	public Long trailingDelta() {
		return trailingDelta;
	}

	@Override
	public String toString() {
		return "StopLossOrder [side=" + side + ", symbol=" + symbol + ", type=" + type + ", quantity=" + quantity
				+ ", stopPrice=" + stopPrice + ", trailingDelta=" + trailingDelta + "]";
	}
}