package com.binance4j.wallet.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Futures account snapshot position. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record FuturesAccountSnapshotPosition(
		/** The asset pair. */
		String symbol,
		/** The entry price. */
		BigDecimal entryPrice,
		/** Mark price. */
		BigDecimal markPrice,
		/** The position amount. */
		@JsonProperty("positionAmt") BigDecimal positionAmount,
		/** Only show the value at the time of opening the position. */
		BigDecimal unRealizedProfit) {
}