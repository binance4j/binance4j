package com.binance4j.websocket.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Pair ticker.
 * 
 * @param eventType                   The event type.
 * @param eventTime                   The timestamp.
 * @param symbol                      The trading pair.
 * @param priceChange                 The price change.
 * @param priceChangePercent          The price change percent.
 * @param weightedAveragePrice        The weighted average price.
 * @param previousDaysClosePrice      The previous days close price.
 * @param currentDaysClosePrice       The current days close price.
 * @param closeTradesQuantity         Last quantity.
 * @param bestBidPrice                Best bid price.
 * @param bestBidQuantity             Best bid quantity.
 * @param bestAskPrice                Best ask price.
 * @param bestAskQuantity             Best ask quantity.
 * @param openPrice                   The open price.
 * @param highPrice                   The highest price.
 * @param lowPrice                    The lowest price.
 * @param totalTradedBaseAssetVolume  Total traded base asset volume.
 * @param totalTradedQuoteAssetVolume Total traded quote asset volume.
 * @param statisticsOpenTime          Statistics open time.
 * @param statisticsCloseTime         Statistics close time.
 * @param firstTradeId                First trade ID.
 * @param lastTradeId                 Last trade Id.
 * @param totalNumberOfTrades         Total number of trades.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Ticker(
		/** The event type. */
		@JsonProperty("e") String eventType,
		/** The timestamp. */
		@JsonProperty("E") Long eventTime,
		/** The trading pair. */
		@JsonProperty("s") String symbol,
		/** The price change. */
		@JsonProperty("p") String priceChange,
		/** The price change percent. */
		@JsonProperty("P") String priceChangePercent,
		/** The weighted average price. */
		@JsonProperty("w") String weightedAveragePrice,
		/** The previous days close price. */
		@JsonProperty("x") String previousDaysClosePrice,
		/** The current days close price. */
		@JsonProperty("c") String currentDaysClosePrice,
		/** Last quantity. */
		@JsonProperty("Q") String closeTradesQuantity,
		/** Best bid price. */
		@JsonProperty("b") String bestBidPrice,
		/** Best bid quantity. */
		@JsonProperty("B") String bestBidQuantity,
		/** Best ask price. */
		@JsonProperty("a") String bestAskPrice,
		/** Best ask quantity. */
		@JsonProperty("A") String bestAskQuantity,
		/** The open price. */
		@JsonProperty("o") String openPrice,
		/** The highest price. */
		@JsonProperty("h") String highPrice,
		/** The lowest price. */
		@JsonProperty("l") String lowPrice,
		/** Total traded base asset volume. */
		@JsonProperty("v") String totalTradedBaseAssetVolume,
		/** Total traded quote asset volume. */
		@JsonProperty("q") String totalTradedQuoteAssetVolume,
		/** Statistics open time. */
		@JsonProperty("O") Long statisticsOpenTime,
		/** Statistics close time. */
		@JsonProperty("C") Long statisticsCloseTime,
		/** First trade ID. */
		@JsonProperty("F") Long firstTradeId,
		/** Last trade Id. */
		@JsonProperty("L") Long lastTradeId,
		/** Total number of trades. */
		@JsonProperty("n") Long totalNumberOfTrades) {
}