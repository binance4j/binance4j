package com.binance4j.spot.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.OrderType;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.dto.TimeInForce;

/** A STOP_LOSS_LIMIT order. */
@Param(weight = 1, isOrder = true, type = RateLimitType.UID_AND_IP)
public class TakeProfitLimitOrder extends BaseOrder {
	/** Order quantity. */
	String quantity;
	/** Order stop price. */
	String stopPrice;
	/** Trailing delta. */
	Long trailingDelta;
	/** Order price. */
	String price;
	/** Order time in force. */
	TimeInForce timeInForce;
	/** Iceberg quantity. */
	String icebergQty;

	/**
	 * 
	 * @param symbol      Symbol.
	 * @param side        Side.
	 * @param quantity    Order quantity.
	 * @param price       Order price.
	 * @param stopPrice   Order price.
	 * @param timeInForce Order time in force.
	 */
	public TakeProfitLimitOrder(String symbol, OrderSide side, String quantity, String price, String stopPrice,
			TimeInForce timeInForce) {
		super(symbol, side, OrderType.TAKE_PROFIT_LIMIT);
		this.quantity = quantity;
		this.price = price;
		this.stopPrice = stopPrice;
		this.timeInForce = timeInForce;
		this.trailingDelta = null;
	}

	/**
	 * 
	 * @param symbol      Symbol.
	 * @param side        Side.
	 * @param quantity    Order quantity.
	 * @param price       Order price.
	 * @param stopPrice   Order price.
	 * @param timeInForce Order time in force.
	 * @param icebergQty  Iceberg quantity.
	 */
	public TakeProfitLimitOrder(String symbol, OrderSide side, String quantity, String price, String stopPrice,
			String icebergQty, TimeInForce timeInForce) {
		super(symbol, side, OrderType.TAKE_PROFIT_LIMIT);
		this.quantity = quantity;
		this.price = price;
		this.stopPrice = stopPrice;
		this.timeInForce = timeInForce;
		this.trailingDelta = null;
		this.icebergQty = icebergQty;
	}

	/**
	 * 
	 * @param symbol        Symbol.
	 * @param side          Side.
	 * @param quantity      Order quantity.
	 * @param price         Order price.
	 * @param timeInForce   Order time in force.
	 * @param trailingDelta Trailing delta.
	 */
	public TakeProfitLimitOrder(String symbol, OrderSide side, String quantity, String price, Long trailingDelta,
			TimeInForce timeInForce) {
		super(symbol, side, OrderType.TAKE_PROFIT_LIMIT);
		this.quantity = quantity;
		this.price = price;
		this.timeInForce = timeInForce;
		this.stopPrice = null;
		this.trailingDelta = trailingDelta;
	}

	/**
	 * 
	 * @param symbol        Symbol.
	 * @param side          Side.
	 * @param quantity      Order quantity.
	 * @param price         Order price.
	 * @param timeInForce   Order time in force.
	 * @param trailingDelta Trailing delta.
	 * @param icebergQty    Iceberg quantity.
	 */
	public TakeProfitLimitOrder(String symbol, OrderSide side, String quantity, String price, Long trailingDelta,
			String icebergQty, TimeInForce timeInForce) {
		super(symbol, side, OrderType.TAKE_PROFIT_LIMIT);
		this.quantity = quantity;
		this.price = price;
		this.timeInForce = timeInForce;
		this.stopPrice = null;
		this.trailingDelta = trailingDelta;
		this.icebergQty = icebergQty;
	}

	/**
	 * Creates an instance of {@link TakeProfitLimitOrder} in the BUY side.
	 * 
	 * @param symbol      Symbol.
	 * @param quantity    Quantity.
	 * @param price       Price.
	 * @param stopPrice   Stop price.
	 * @param timeInForce Time in force.
	 * @return An instance of {@link TakeProfitLimitOrder}.
	 */
	public static TakeProfitLimitOrder buy(String symbol, String quantity, String price, String stopPrice,
			TimeInForce timeInForce) {
		return new TakeProfitLimitOrder(symbol, OrderSide.BUY, quantity, price, stopPrice, timeInForce);
	}

	/**
	 * Creates an instance of {@link TakeProfitLimitOrder} in the SELL side.
	 * 
	 * @param symbol      Symbol.
	 * @param quantity    Quantity.
	 * @param price       Price.
	 * @param stopPrice   Stop price.
	 * @param timeInForce Time in force.
	 * @return An instance of {@link TakeProfitLimitOrder}.
	 */
	public static TakeProfitLimitOrder sell(String symbol, String quantity, String price, String stopPrice,
			TimeInForce timeInForce) {
		return new TakeProfitLimitOrder(symbol, OrderSide.SELL, quantity, price, stopPrice, timeInForce);
	}

	/**
	 * Creates an instance of {@link TakeProfitLimitOrder} in the BUY side.
	 * 
	 * @param symbol    Symbol.
	 * @param quantity  Quantity.
	 * @param price     Price.
	 * @param stopPrice Stop price.
	 * @return An instance of {@link TakeProfitLimitOrder}.
	 */
	public static TakeProfitLimitOrder buy(String symbol, String quantity, String price, String stopPrice) {
		return new TakeProfitLimitOrder(symbol, OrderSide.BUY, quantity, price, stopPrice, TimeInForce.GTC);
	}

	/**
	 * Creates an instance of {@link TakeProfitLimitOrder} in the SELL side.
	 * 
	 * @param symbol    Symbol.
	 * @param quantity  Quantity.
	 * @param price     Price.
	 * @param stopPrice Stop price.
	 * @return An instance of {@link TakeProfitLimitOrder}.
	 */
	public static TakeProfitLimitOrder sell(String symbol, String quantity, String price, String stopPrice) {
		return new TakeProfitLimitOrder(symbol, OrderSide.SELL, quantity, price, stopPrice, TimeInForce.GTC);
	}

	/**
	 * Creates an instance of {@link TakeProfitLimitOrder} in the BUY side.
	 * 
	 * @param symbol        Symbol.
	 * @param quantity      Quantity.
	 * @param price         Price.
	 * @param trailingDelta Trailing delta.
	 * @return An instance of {@link TakeProfitLimitOrder}.
	 */
	public static TakeProfitLimitOrder buy(String symbol, String quantity, String price, Long trailingDelta) {
		return new TakeProfitLimitOrder(symbol, OrderSide.BUY, quantity, price, trailingDelta, TimeInForce.GTC);
	}

	/**
	 * Creates an instance of {@link TakeProfitLimitOrder} in the SELL side.
	 * 
	 * @param symbol        Symbol.
	 * @param quantity      Quantity.
	 * @param price         Price.
	 * @param trailingDelta Trailing delta.
	 * @return An instance of {@link TakeProfitLimitOrder}.
	 */
	public static TakeProfitLimitOrder sell(String symbol, String quantity, String price, Long trailingDelta) {
		return new TakeProfitLimitOrder(symbol, OrderSide.SELL, quantity, price, trailingDelta, TimeInForce.GTC);
	}

	/**
	 * Creates an instance of {@link TakeProfitLimitOrder} in the BUY side.
	 * 
	 * @param symbol        Symbol.
	 * @param quantity      Quantity.
	 * @param price         Price.
	 * @param trailingDelta Trailing delta.
	 * @return An instance of {@link TakeProfitLimitOrder}.
	 */
	public static TakeProfitLimitOrder buy(String symbol, String quantity, String price, Long trailingDelta,
			TimeInForce timeInForce) {
		return new TakeProfitLimitOrder(symbol, OrderSide.BUY, quantity, price, trailingDelta, timeInForce);
	}

	/**
	 * Creates an instance of {@link TakeProfitLimitOrder} in the SELL side.
	 * 
	 * @param symbol        Symbol.
	 * @param quantity      Quantity.
	 * @param price         Price.
	 * @param trailingDelta Trailing delta.
	 * @return An instance of {@link TakeProfitLimitOrder}.
	 */
	public static TakeProfitLimitOrder sell(String symbol, String quantity, String price, Long trailingDelta,
			TimeInForce timeInForce) {
		return new TakeProfitLimitOrder(symbol, OrderSide.SELL, quantity, price, trailingDelta, timeInForce);
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

	/**
	 * @return the timeInForce
	 */
	public TimeInForce getTimeInForce() {
		return timeInForce;
	}

	/**
	 * @param timeInForce the timeInForce to set
	 */
	public void setTimeInForce(TimeInForce timeInForce) {
		this.timeInForce = timeInForce;
	}

	/**
	 * @return the icebergQty
	 */
	public String getIcebergQty() {
		return icebergQty;
	}

	/**
	 * @param icebergQty the icebergQty to set
	 */
	public void setIcebergQty(String icebergQty) {
		this.icebergQty = icebergQty;
	}

	@Override
	public String toString() {
		return "TakeProfitLimitOrder [side=" + side + ", symbol=" + symbol + ", type=" + type + ", price=" + price
				+ ", quantity=" + quantity + ", stopPrice=" + stopPrice
				+ ", timeInForce=" + timeInForce + ", trailingDelta=" + trailingDelta + "]";
	}

}