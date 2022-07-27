package com.binance4j.websocket.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Minimal infos Ticker.
 * 
 * @param eventType                   The event type.
 * @param eventTime                   The timestamp.
 * @param symbol                      The trading pair.
 * @param closePrice                  The close price.
 * @param openPrice                   The open price.
 * @param highPrice                   The highest price.
 * @param lowPrice                    The lowest price.
 * @param totalTradedBaseAssetVolume  Total traded base asset volume.
 * @param totalTradedQuoteAssetVolume Total traded quote asset volume.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public record MiniTicker(
		/** The event type. */
		@JsonProperty("e") String eventType,
		/** The timestamp. */
		@JsonProperty("E") Long eventTime,
		/** The trading pair. */
		@JsonProperty("s") String symbol,
		/** The close price. */
		@JsonProperty("c") String closePrice,
		/** The open price. */
		@JsonProperty("o") String openPrice,
		/** The highest price. */
		@JsonProperty("h") String highPrice,
		/** The lowest price. */
		@JsonProperty("l") String lowPrice,
		/** Total traded base asset volume. */
		@JsonProperty("v") String totalTradedBaseAssetVolume,
		/** Total traded quote asset volume. */
		@JsonProperty("q") String totalTradedQuoteAssetVolume) {
}