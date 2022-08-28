package com.binance4j.spot.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.OrderType;
import com.binance4j.core.dto.RateLimitType;

/** A MARKET order defined by the quote asset quantity. */
@Param(weight = 1, isOrder = true, type = RateLimitType.UID_AND_IP)
public class MarketQuoteOrder extends BaseOrder {
	/** Quote asset quantity. */
	String quoteOrderQty;

	/**
	 * @param symbol        Order symbol.
	 * @param side          Order side.
	 * @param quoteOrderQty Quote order quantity.
	 */
	public MarketQuoteOrder(String symbol, OrderSide side, String quoteOrderQty) {
		super(symbol, side, OrderType.MARKET);
		this.quoteOrderQty = quoteOrderQty;
	}

	/**
	 * Creates an instance of {@link MarketQuoteOrder} in a BUY side.
	 *
	 * @param symbol        Asset pair.
	 * @param quoteOrderQty Quote order quantity.
	 * @return An instance of {@link MarketOrder}.
	 */
	public static MarketQuoteOrder buy(String symbol, String quoteOrderQty) {
		return new MarketQuoteOrder(symbol, OrderSide.BUY, quoteOrderQty);
	}

	/**
	 * Creates an instance of {@link MarketQuoteOrder} in a SELL side.
	 *
	 * @param symbol        Asset pair.
	 * @param quoteOrderQty Quote order quantity.
	 * @return An instance of {@link MarketOrder}.
	 */
	public static MarketQuoteOrder sell(String symbol, String quoteOrderQty) {
		return new MarketQuoteOrder(symbol, OrderSide.SELL, quoteOrderQty);
	}

	/**
	 * @return the quoteOrderQty
	 */
	public String getquoteOrderQty() {
		return quoteOrderQty;
	}

	/**
	 * @param quoteOrderQty the quoteOrderQty to set
	 */
	public void setquoteOrderQty(String quoteOrderQty) {
		this.quoteOrderQty = quoteOrderQty;
	}

	@Override
	public String toString() {
		return "MarketOrder [side=" + side + ", symbol=" + symbol + ", type=" + type + ", quoteOrderQty="
				+ quoteOrderQty + "]";
	}
}