package com.binance4j.margin.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Isolated margin fee
 * 
 * @param vipLevel The VIP level.
 * @param symbol   The related symbol.
 * @param leverage The leverage.
 * @param data     The isolated fee data.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record IsolatedFee(
		/** The VIP level. */
		int vipLevel,
		/** The related symbol. */
		String symbol,
		/** The leverage. */
		BigDecimal leverage,
		/** The isolated fee data. */
		List<IsolatedFeeData> data) {
}