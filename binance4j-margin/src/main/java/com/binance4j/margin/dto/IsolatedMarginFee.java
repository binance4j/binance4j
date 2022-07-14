package com.binance4j.margin.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record IsolatedMarginFee(
		/** TODO JAVADOC. */
		int vipLevel,
		/** TODO JAVADOC. */
		String symbol,
		/** TODO JAVADOC. */
		BigDecimal leverage,
		/** TODO JAVADOC. */
		List<IsolatedMarginFeeData> data) {
}