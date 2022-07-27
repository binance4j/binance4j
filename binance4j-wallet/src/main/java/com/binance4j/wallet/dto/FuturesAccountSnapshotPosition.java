package com.binance4j.wallet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Futures account snapshot position. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record FuturesAccountSnapshotPosition(
		/** The asset pair. */
		String symbol,
		/** The entry price. */
		String entryPrice,
		/** Mark price. */
		String markPrice,
		/** The position amount. */
		@JsonProperty("positionAmt") String positionAmount,
		/** Only show the value at the time of opening the position. */
		String unRealizedProfit) {
}