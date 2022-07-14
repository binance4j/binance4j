package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record IsolatedMarginFeeData(
		/** TODO JAVADOC. */
		String coin,
		/** TODO JAVADOC. */
		BigDecimal dailyInterest,
		/** TODO JAVADOC. */
		BigDecimal borrowLimit) {
}