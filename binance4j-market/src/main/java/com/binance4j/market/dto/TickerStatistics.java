package com.binance4j.market.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public record TickerStatistics(
		/** Ticker symbol. */
		String symbol,
		/** Price change during the last 24 hours. */
		BigDecimal priceChange,
		/** Price change; in percentage; during the last 24 hours. */
		BigDecimal priceChangePercent,
		/** Weighted average price. */
		BigDecimal weightedAvgPrice,
		/** Previous close price. */
		BigDecimal prevClosePrice,
		/** Last price. */
		BigDecimal lastPrice,
		/** Last quantity. */
		@JsonProperty("lastQty") BigDecimal lastQuantity,
		/** Bid price. */
		BigDecimal bidPrice,
		/** Bid quantity. */
		@JsonProperty("bidQty") BigDecimal bidQuantity,
		/** Ask price. */
		BigDecimal askPrice,
		/** Ask quantity. */
		@JsonProperty("askQty") BigDecimal askQuantity,
		/** Open price 24 hours ago. */
		BigDecimal openPrice,
		/** Highest price during the past 24 hours. */
		BigDecimal highPrice,
		/** Lowest price during the past 24 hours. */
		BigDecimal lowPrice,
		/** Total volume during the past 24 hours. */
		BigDecimal volume,
		/** Total quote volume during the past 24 hours. */
		BigDecimal quoteVolume,
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
