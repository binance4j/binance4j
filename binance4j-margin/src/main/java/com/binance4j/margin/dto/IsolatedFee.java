package com.binance4j.margin.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Isolated margin fee
 * 
 * @param vipLevel
 * @param symbol
 * @param leverage
 * @param data
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record IsolatedFee(
		/** The VIP level. */
		int vipLevel,
		/** The related symbol. */
		String symbol,
		/** The leverage. */
		BigDecimal leverage,
		/** TODO JAVADOC. */
		List<IsolatedFeeData> data) {
}