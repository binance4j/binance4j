package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InterestRate(
		/** TODO JAVADOC. */
		String asset,
		/** TODO JAVADOC. */
		BigDecimal dailyInterestRate,
		/** TODO JAVADOC. */
		long timestamp,
		/** TODO JAVADOC. */
		int vipLevel) {
}