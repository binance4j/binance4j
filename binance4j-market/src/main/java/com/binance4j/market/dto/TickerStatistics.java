package com.binance4j.market.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** 24 hour price change statistics for a ticker. */
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
		BigDecimal lastQty,
		/** Bid price. */
		BigDecimal bidPrice,
		/** Bid quantity. */
		BigDecimal bidQty,
		/** Ask price. */
		BigDecimal askPrice,
		/** Ask quantity. */
		BigDecimal askQty,
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
