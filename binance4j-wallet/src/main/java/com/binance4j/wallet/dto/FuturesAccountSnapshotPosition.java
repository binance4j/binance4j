package com.binance4j.wallet.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Futures account snapshot position. */
public record FuturesAccountSnapshotPosition(String symbol, String entryPrice, String markPrice, @JsonProperty("positionAmt") String positionAmount,
		String unRealizedProfit) {
}