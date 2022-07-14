package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Asset balance in an {@link Account}. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record AssetBalance(
		String asset,
		BigDecimal borrowed,
		BigDecimal free,
		BigDecimal interest,
		BigDecimal locked,
		BigDecimal netAsset) {
}