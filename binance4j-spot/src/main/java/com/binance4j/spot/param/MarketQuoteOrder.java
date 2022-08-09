package com.binance4j.spot.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.OrderType;
import com.binance4j.core.dto.RateLimitType;

/** A MARKET order defined by the quote asset quantity. */
@Param(weight = 1, isOrder = true, type = RateLimitType.UID_AND_IP)
public class MarketQuoteOrder extends BaseOrder {
	/** Quote asset quantity. */
	String quoteAssetQty;

	/**
	 * @param symbol        Order symbol.
	 * @param side          Order side.
	 * @param quoteAssetQty Quote order quantity.
	 */
	private MarketQuoteOrder(String symbol, OrderSide side, String quoteAssetQty) {
		super(symbol, side, OrderType.MARKET);
		this.quoteAssetQty = quoteAssetQty;
	}

	/**
	 * Creates an instance of {@link MarketQuoteOrder} in a BUY side.
	 *
	 * @param symbol   Asset pair.
	 * @param quantity Quantity.
	 * @return An instance of {@link MarketOrder}.
	 */
	public static MarketQuoteOrder buy(String symbol, String quoteAssetQty) {
		return new MarketQuoteOrder(symbol, OrderSide.BUY, quoteAssetQty);
	}

	/**
	 * Creates an instance of {@link MarketQuoteOrder} in a SELL side.
	 *
	 * @param symbol   Asset pair.
	 * @param quantity Quantity.
	 * @return An instance of {@link MarketOrder}.
	 */
	public static MarketQuoteOrder sell(String symbol, String quoteAssetQty) {
		return new MarketQuoteOrder(symbol, OrderSide.SELL, quoteAssetQty);
	}

	/**
	 * @return the quoteAssetQty
	 */
	public String quoteAssetQty() {
		return quoteAssetQty;
	}

	/**
	 * @param quoteAssetQty the quoteAssetQty to set
	 */
	public MarketQuoteOrder quoteAssetQty(String quoteAssetQty) {
		this.quoteAssetQty = quoteAssetQty;
		return this;
	}

	@Override
	public String toString() {
		return "MarketOrder [side=" + side + ", symbol=" + symbol + ", type=" + type + ", quoteAssetQty="
				+ quoteAssetQty + "]";
	}

}