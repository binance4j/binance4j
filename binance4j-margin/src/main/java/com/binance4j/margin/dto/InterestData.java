package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InterestData(
		// isolated symbol, will not be returned for crossed margin
		/** TODO JAVADOC. */
		String isolatedSymbol,
		/** TODO JAVADOC. */
		String asset,
		/** TODO JAVADOC. */
		Long interestAccuredTime,
		/** TODO JAVADOC. */
		BigDecimal interest,
		/** TODO JAVADOC. */
		BigDecimal interestRate,
		/** TODO JAVADOC. */
		BigDecimal principal,
		/** TODO JAVADOC. */
		InterestType type) {
}
