package com.binance4j.websocket.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Minimal infos Ticker */

@JsonIgnoreProperties(ignoreUnknown = true)
public record MiniTicker(/** The event type. */
@JsonProperty("e") String eventType,
		/** The timestamp. */
		@JsonProperty("E") Long eventTime,
		/** The trading pair. */
		@JsonProperty("s") String symbol,
		/** The close price. */
		@JsonProperty("c") BigDecimal closePrice,
		/** The open price. */
		@JsonProperty("o") BigDecimal openPrice,
		/** The highest price. */
		@JsonProperty("h") BigDecimal highPrice,
		/** The lowest price. */
		@JsonProperty("l") BigDecimal lowPrice,
		/** Total traded base asset volume. */
		@JsonProperty("v") BigDecimal totalTradedBaseAssetVolume,
		/** Total traded quote asset volume. */
		@JsonProperty("q") BigDecimal totalTradedQuoteAssetVolume) {
}