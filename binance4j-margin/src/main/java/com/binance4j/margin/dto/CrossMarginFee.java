package com.binance4j.margin.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CrossMarginFee(
		/** TODO JAVADOC. */
		int vipLevel,
		/** TODO JAVADOC. */
		String coin,
		/** TODO JAVADOC. */
		boolean transferIn,
		/** TODO JAVADOC. */
		boolean borrowable,
		/** TODO JAVADOC. */
		BigDecimal dailyInterest,
		/** TODO JAVADOC. */
		BigDecimal yearlyInterest,
		/** TODO JAVADOC. */
		BigDecimal borrowLimit,
		/** TODO JAVADOC. */
		List<String> marginablePairs) {
}