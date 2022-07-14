package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record IsolatedMarginFeeData(
		String coin,
		BigDecimal dailyInterest,
		BigDecimal borrowLimit) {
}