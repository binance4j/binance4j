package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.OrderType;
import com.binance4j.core.dto.RateLimitType;

/** A TAKE_PROFIT order. */
@Param(weight = 1, isOrder = true, type = RateLimitType.UID_AND_IP)
public class TakeProfitOrder extends BaseOrder {
	/** Order quantity. */
	String quantity;
	/** Order stop price. */
	String stopPrice;
	/** Trailing delta. */
	Long trailingDelta;

	/**
	 * 
	 * @param symbol    Symbol.
	 * @param side      Side.
	 * @param quantity  Order quantity.
	 * @param stopPrice Order price.
	 */
	public TakeProfitOrder(String symbol, OrderSide side, String quantity, String stopPrice) {
		super(symbol, side, OrderType.TAKE_PROFIT);
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
	public TakeProfitOrder(String symbol, OrderSide side, String quantity, Long trailingDelta) {
		super(symbol, side, OrderType.TAKE_PROFIT);
		this.quantity = quantity;
		this.trailingDelta = trailingDelta;
		this.stopPrice = null;
	}

	/**
	 * Creates an instance of {@link TakeProfitOrder} in the BUY side.
	 * 
	 * @param symbol    Symbol.
	 * @param quantity  Quantity.
	 * @param stopPrice Stop price.
	 * @return An instance of {@link TakeProfitOrder}.
	 */
	public static TakeProfitOrder buy(String symbol, String quantity, String stopPrice) {
		return new TakeProfitOrder(symbol, OrderSide.BUY, quantity, stopPrice);
	}

	/**
	 * Creates an instance of {@link TakeProfitOrder} in the SELL side.
	 * 
	 * @param symbol    Symbol.
	 * @param quantity  Quantity.
	 * @param stopPrice Stop price.
	 * @return An instance of {@link TakeProfitOrder}.
	 */
	public static TakeProfitOrder sell(String symbol, String quantity, String stopPrice) {
		return new TakeProfitOrder(symbol, OrderSide.SELL, quantity, stopPrice);
	}

	/**
	 * Creates an instance of {@link TakeProfitOrder} in the BUY side.
	 * 
	 * @param symbol        Symbol.
	 * @param quantity      Quantity.
	 * @param trailingDelta Trailing delta.
	 * @return An instance of {@link TakeProfitOrder}.
	 */
	public static TakeProfitOrder buy(String symbol, String quantity, Long trailingDelta) {
		return new TakeProfitOrder(symbol, OrderSide.BUY, quantity, trailingDelta);
	}

	/**
	 * Creates an instance of {@link TakeProfitOrder} in the SELL side.
	 * 
	 * @param symbol        Symbol.
	 * @param quantity      Quantity.
	 * @param trailingDelta Trailing delta.
	 * @return An instance of {@link TakeProfitOrder}.
	 */
	public static TakeProfitOrder sell(String symbol, String quantity, Long trailingDelta) {
		return new TakeProfitOrder(symbol, OrderSide.SELL, quantity, trailingDelta);
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
	 * @return the stopPrice
	 */
	public String getStopPrice() {
		return stopPrice;
	}

	/**
	 * @param stopPrice the stopPrice to set
	 */
	public void setStopPrice(String stopPrice) {
		this.stopPrice = stopPrice;
	}

	/**
	 * @return the trailingDelta
	 */
	public Long getTrailingDelta() {
		return trailingDelta;
	}

	/**
	 * @param trailingDelta the trailingDelta to set
	 */
	public void setTrailingDelta(Long trailingDelta) {
		this.trailingDelta = trailingDelta;
	}

	@Override
	public String toString() {
		return "TakeProfitOrder [side=" + side + ", symbol=" + symbol + ", type=" + type + ", quantity=" + quantity
				+ ", stopPrice=" + stopPrice + ", trailingDelta=" + trailingDelta + "]";
	}

}