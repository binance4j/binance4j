package com.binance4j.margin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Pair(
		Long id,
		String symbol,
		String base,
		String quote,
		Boolean isMarginTrade,
		Boolean isBuyAllowed,
		Boolean isSellAllowed) {
}
