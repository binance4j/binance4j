package com.binance4j.market.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 24 hour price change statistics for a ticker.
 * 
 * @param symbol             Ticker symbol.
 * @param priceChange        Price change during the last 24 hours.
 * @param priceChangePercent Price change; in percentage; during the last 24 hours.
 * @param weightedAvgPrice   Weighted average price.
 * @param prevClosePrice     Previous close price.
 * @param lastPrice          Last price.
 * @param lastQuantity       Last quantity.
 * @param bidPrice           Bid price.
 * @param bidQuantity        Bid quantity.
 * @param askPrice           Ask price.
 * @param askQuantity        Ask quantity.
 * @param openPrice          Open price 24 hours ago.
 * @param highPrice          Highest price during the past 24 hours.
 * @param lowPrice           Lowest price during the past 24 hours.
 * @param volume             Total volume during the past 24 hours.
 * @param quoteVolume        Total quote volume during the past 24 hours.
 * @param openTime           Open time.
 * @param closeTime          Close time.
 * @param firstId            First trade id.
 * @param lastId             Last trade id.
 * @param count              Total number of trades during the last 24 hours.
 */
public record TickerStatistics(
		/** Ticker symbol. */
		String symbol,
		/** Price change during the last 24 hours. */
		String priceChange,
		/** Price change; in percentage; during the last 24 hours. */
		String priceChangePercent,
		/** Weighted average price. */
		String weightedAvgPrice,
		/** Previous close price. */
		String prevClosePrice,
		/** Last price. */
		String lastPrice,
		/** Last quantity. */
		@JsonProperty("lastQty") String lastQuantity,
		/** Bid price. */
		String bidPrice,
		/** Bid quantity. */
		@JsonProperty("bidQty") String bidQuantity,
		/** Ask price. */
		String askPrice,
		/** Ask quantity. */
		@JsonProperty("askQty") String askQuantity,
		/** Open price 24 hours ago. */
		String openPrice,
		/** Highest price during the past 24 hours. */
		String highPrice,
		/** Lowest price during the past 24 hours. */
		String lowPrice,
		/** Total volume during the past 24 hours. */
		String volume,
		/** Total quote volume during the past 24 hours. */
		String quoteVolume,
		/** Open time. */
		long openTime,
		/** Close time. */
		long closeTime,
		/** First trade id. */
		long firstId,
		/** Last trade id. */
		long lastId,
		/** Total number of trades during the last 24 hours. */
		long count) {
}
