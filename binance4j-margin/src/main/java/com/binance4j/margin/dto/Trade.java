package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Trade(
		String symbol,
		String commissionAsset,
		BigDecimal commission,
		BigDecimal price,
		@JsonProperty("qty") BigDecimal quantity,
		long id,
		long orderId,
		long time,
		boolean isBestMatch,
		boolean isBuyer,
		boolean isMaker,
		boolean isIsolated) {
}