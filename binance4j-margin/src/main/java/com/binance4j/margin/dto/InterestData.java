package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InterestData(
		// isolated symbol, will not be returned for crossed margin
		String isolatedSymbol,
		String asset,
		Long interestAccuredTime,
		BigDecimal interest,
		BigDecimal interestRate,
		BigDecimal principal,
		InterestType type) {
}
