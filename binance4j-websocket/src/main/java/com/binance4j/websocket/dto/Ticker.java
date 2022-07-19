package com.binance4j.websocket.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Pair ticker */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Ticker(/** The event type. */
@JsonProperty("e") String eventType,
		/** The timestamp. */
		@JsonProperty("E") Long eventTime,
		/** The trading pair. */
		@JsonProperty("s") String symbol,
		/** The price change. */
		@JsonProperty("p") BigDecimal priceChange,
		/** The price change percent. */
		@JsonProperty("P") BigDecimal priceChangePercent,
		/** The waighted average price. */
		@JsonProperty("w") BigDecimal weightedAveragePrice,
		/** The previous days close price. */
		@JsonProperty("x") BigDecimal previousDaysClosePrice,
		/** The current days close price. */
		@JsonProperty("c") BigDecimal currentDaysClosePrice,
		/** Last quantity. */
		@JsonProperty("Q") BigDecimal closeTradesQuantity,
		/** Best bid price. */
		@JsonProperty("b") BigDecimal bestBidPrice,
		/** Best bid quantity. */
		@JsonProperty("B") BigDecimal bestBidQuantity,
		/** Best ask price. */
		@JsonProperty("a") BigDecimal bestAskPrice,
		/** Best ask quantity. */
		@JsonProperty("A") BigDecimal bestAskQuantity,
		/** The open price. */
		@JsonProperty("o") BigDecimal openPrice,
		/** The highest price. */
		@JsonProperty("h") BigDecimal highPrice,
		/** The lowest price. */
		@JsonProperty("l") BigDecimal lowPrice,
		/** Total traded base asset volume. */
		@JsonProperty("v") BigDecimal totalTradedBaseAssetVolume,
		/** Total traded quote asset volume. */
		@JsonProperty("q") BigDecimal totalTradedQuoteAssetVolume,
		/** Statistics open time. */
		@JsonProperty("O") Long statisticsOpenTime,
		/** Statistics close time. */
		@JsonProperty("C") Long statisticsCloseTime,
		/** First trade ID. */
		@JsonProperty("F") Long firstTradeId,
		/** Last trade Id. */
		@JsonProperty("L") Long lastTradeId, /** Total number of trades. */
		@JsonProperty("n") Long totalNumberOfTrades) {
}